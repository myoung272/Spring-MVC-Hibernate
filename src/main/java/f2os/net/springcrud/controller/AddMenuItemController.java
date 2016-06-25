package f2os.net.springcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import f2os.net.springcrud.model.Menu;
import f2os.net.springcrud.service.MenuService;
import f2os.net.springcrud.util.FileBucket;
import f2os.net.springcrud.util.SortMenu;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/addMenuItem")
public class AddMenuItemController implements ServletContextAware {

    @Autowired
    private MenuService menuService;
    
    private ServletContext servletContext;
    
    @Override // method from interface ServletContextAware
     public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
    
     List<Menu> menu;
    Set<Menu> catList;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showSingleMenuForm() {
        ModelAndView modelAndView = new ModelAndView("addMenuItem");
        modelAndView.addObject("addItem", new Menu());
        modelAndView.addObject("fileBucket", new FileBucket());
        return modelAndView;
    }

    // ADD SINGLE ITEM 
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView uploadSingleMenuItemToDB(@ModelAttribute Menu addItem) {
        System.out.println("In processForm of AddMenuItemController" + addItem);
        menuService.saveMenuItem(addItem);
        String message = "Menu item:  " + addItem.getItem() + " was successfully added.";
        ModelAndView modelAndView = new ModelAndView("addMenuItem"); 
        modelAndView.addObject("message", message);
        modelAndView.addObject("addItem", new Menu());
        // Reload Menu and catList after new menu item added
      reloadMenuAndCatList();
        return modelAndView;
    }
    
    // EDIT MENU ITEM
   @RequestMapping(value="/edit" ,method = RequestMethod.POST)
   public ModelAndView editMenuItem( HttpServletRequest request) {
         ModelAndView modelAndView = new ModelAndView("addMenuItem"); 
       Menu m = new Menu();
       m.setProductId(Integer.parseInt(request.getParameter("productId")));
       m.setCategory(request.getParameter("category"));
       m.setItem(request.getParameter("item"));
       m.setPrice(new BigDecimal(request.getParameter("price")));
       m.setSize(request.getParameter("size"));
       m.setDescription(request.getParameter("description"));
       menuService.editMenuItem(m);
       reloadMenuAndCatList();
          modelAndView.addObject("menuList", menu);
        return modelAndView;
   }
   
   // REMOVE ITEM
   @RequestMapping(value="/remove" ,method = RequestMethod.POST)
   public ModelAndView removeMenuItem( HttpServletRequest request) {
       menuService.removeMenuItem(Integer.parseInt(request.getParameter("productId")));
         ModelAndView modelAndView = new ModelAndView("addMenuItem"); 
          reloadMenuAndCatList();
          modelAndView.addObject("menuList", menu);
          return modelAndView;
   }
    
      @RequestMapping(value="/uploadEx" ,method = RequestMethod.GET)
    public ModelAndView showuploadExcelForm() {
        ModelAndView modelAndView = new ModelAndView("uploadExcel");
        modelAndView.addObject("fileBucket", new FileBucket());
        return modelAndView;
    }
     
    // UPLOAD MENU FROM EXCEL SHEET
     @RequestMapping(value = "/uploadEx", method = RequestMethod.POST)
    public ModelAndView uploadExcelToDB(@ModelAttribute FileBucket fb) throws Exception {
      ModelAndView modelAndView = new ModelAndView("redirect:/");
      menuService.setAllMenuItemsInactive();
     System.out.println("In handelFormUpload file name is: "+fb);
    ByteArrayInputStream bis = new ByteArrayInputStream(fb.getFile().getBytes());
     Workbook workbook;
     Sheet sheet;
      try {
            if (fb.getFile().getOriginalFilename().endsWith("xls")) {
                workbook = new HSSFWorkbook(bis);
              sheet = workbook.getSheetAt(0);
            } else if (fb.getFile().getOriginalFilename().endsWith("xlsx")) {
                workbook = new XSSFWorkbook(bis);
                sheet = workbook.getSheetAt(0);
            } else {
                throw new IllegalArgumentException("Received file does not have a standard excel extension.");
            }

            for (Row row : sheet) {
                if(isEmptyRow(row)){
                    break;
                }
              
                  Menu menu = new Menu();
               if (row.getRowNum() != 0) {
                  Iterator<Cell> cellIterator = row.cellIterator();
                  while (cellIterator.hasNext()) {
                    
                      Cell cell = cellIterator.next();
                      
                   
                 switch (cell.getCellType()) {
                case Cell.CELL_TYPE_STRING:
                    System.out.println(cell.getRichStringCellValue().getString());
                    switch(cell.getColumnIndex()){
                        case  0:
                            menu.setCategory(cell.getRichStringCellValue().getString());
                            break;
                        case 1:
                            menu.setItem(cell.getRichStringCellValue().getString());
                            break;
                        case 2:
                            menu.setDescription(cell.getRichStringCellValue().getString());
                            break;
                        case 3:
                            menu.setSize(cell.getRichStringCellValue().getString());
                            break;
                    } //  1st nested switch
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                        System.out.println(cell.getNumericCellValue());
                         switch(cell.getColumnIndex()){
                             case 4:
                                 menu.setPrice(new BigDecimal(cell.getNumericCellValue()));
                                 break;
                          
                          /*   case 5:
                                 Double active = cell.getNumericCellValue();
                                 menu.setActive(active.intValue());
                                 break;
                          */
                         } // end 2nd nested switch
                    break;
                default:
                    System.out.println();
            } // end outer switch
                  } // end while
                  
                  menu.setActive(0);
                   menuService.saveMenuItem(menu);
              }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
      // Reload Menu and catList after new menu item added
       reloadMenuAndCatList();
      return modelAndView;
    }
    
    public void reloadMenuAndCatList() {
          menu = menuService.getMenu();
        servletContext.setAttribute("menu", menu);
        catList = (TreeSet) SortMenu.uniqueCategories(menu);
        servletContext.setAttribute("cats", catList);
    }
    
  public   boolean isEmptyRow(Row row){
     boolean isEmptyRow = true;
         for(int cellNum = row.getFirstCellNum(); cellNum < row.getLastCellNum(); cellNum++){
            Cell cell = row.getCell(cellNum);
            if(cell != null && cell.getCellType() != Cell.CELL_TYPE_BLANK && StringUtils.isNotBlank(cell.toString())){
            isEmptyRow = false;
            }    
         }
     return isEmptyRow;
   }
    
    }

