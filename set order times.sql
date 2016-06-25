SELECT * FROM springfos.order_hours;

update order_hours set mo='08:00:00', tu='08:00:00', we='08:00:00',tr='08:00:00',fr='08:00:00',sa='08:00:00',su='08:00:00',
fmo = '23:59:00', ftu = '23:59:00', fwe = '23:59:00', ftr = '23:59:00', ffr = '23:59:00', fsa = '23:59:00', fsu = '23:59:00', on = true, sms_on = true
where id = 1;
