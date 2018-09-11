
INSERT INTO QXMA_FT_BANK_ACCT_CLASS(ba_id, code, description) values(1,'BUSINESS','BUSINESS ACCOUNT');
INSERT INTO QXMA_FT_BANK_ACCT_CLASS(ba_id, code, description) values(2,'PERSONAL','PERSONAL ACCOUNT');

INSERT INTO QXMA_FT_BANK_ACCT_TYPE(BA_TYPE, CODE, DESCRIPTION) VALUES(1,'LOCAL','LOCAL ACCOUNT');
INSERT INTO QXMA_FT_BANK_ACCT_TYPE(BA_TYPE, CODE, DESCRIPTION) VALUES(2,'FOREIGN','FOREIGN ACCOUNT');

INSERT INTO qxma_ft_charge_status(cs_id, code, description) values (1, 'PENDING', 'PENDING');
INSERT INTO qxma_ft_charge_status(cs_id, code, description) values (2, 'PAID', 'PAID');
INSERT INTO qxma_ft_charge_status(cs_id, code, description) values (3, 'REMITTED', 'REMITTED');

insert into qxma_ft_match_status(ms_id, code, description) values (1, 'MATCH', 'MATCH');
insert into qxma_ft_match_status(ms_id, code, description) values (2, 'OVER_REMIT', 'OVER_REMIT');
insert into qxma_ft_match_status(ms_id, code, description) values (3, 'UNDER_REMIT', 'UNDER_REMIT');

insert into qxma_ft_ledger_status(ledger_status_id, code, description) values (1, 'SETTLED', 'SETTLED');
insert into qxma_ft_ledger_status(ledger_status_id, code, description) values (2, 'PENDING', 'PENDING');

insert into qxma_ft_ledger_type(ledger_type_id, code, description) values(1, 'PAYABLE', 'PAYABLE');
insert into qxma_ft_ledger_type(ledger_type_id, code, description) values(2, 'RECEIVABLE', 'RECEIVABLE');

insert into qxma_ft_transfer_type(type_id, code, description) values(1, 'PURCHASE', 'PURCHASE');
insert into qxma_ft_transfer_type(type_id, code, description) values(2, 'TRANSFER', 'TRANSFER');
insert into qxma_ft_transfer_type(type_id, code, description) values(3, 'REFUND', 'REFUND');
insert into qxma_ft_transfer_type(type_id, code, description) values(4, 'REWARD', 'REWARD');
insert into qxma_ft_transfer_type(type_id, code, description) values(5, 'ESCROW', 'ESCROW');
insert into qxma_ft_transfer_type(type_id, code, description) values(6, 'DISBURSEMENT', 'DISBURSEMENT');
insert into qxma_ft_transfer_type(type_id, code, description) values(7, 'SETTLEMENT', 'SETTLEMENT');
insert into qxma_ft_transfer_type(type_id, code, description) values(8, 'SALE', 'SALE');
insert into qxma_ft_transfer_type(type_id, code, description) values(9, 'FUND', 'FUND');
insert into qxma_ft_transfer_type(type_id, code, description) values(10, 'RETURN', 'RETURN');
insert into qxma_ft_transfer_type(type_id, code, description) values(11, 'CLAIM', 'CLAIM');
insert into qxma_ft_transfer_type(type_id, code, description) values(12, 'COLLECTION', 'COLLECTION');
insert into qxma_ft_transfer_type(type_id, code, description) values(13, 'COLLECTION REVERSAL', 'COLLECTION REVERSA');
insert into qxma_ft_transfer_type(type_id, code, description) values(14, 'SALES REVERSAL', 'SALES REVERSAL');

insert into qxma_ft_wallet_type(wt_id, code, description) values(1, 'COLLECTION', 'COLLECTION');
insert into qxma_ft_wallet_type(wt_id, code, description) values(2, 'FUND', 'FUND');
insert into qxma_ft_wallet_type(wt_id, code, description) values(3, 'SALES', 'SALES');
insert into qxma_ft_wallet_type(wt_id, code, description) values(4, 'SETTLEMENT', 'SETTLEMENT');

INSERT INTO `qxma_payload` VALUES ('1','0010-5246-CYKH','orders',NULL,'PH','{\"shipping_fee\": 240, \"insurance_fee\": 23, \"transaction_fee\": 80.5}',50000,'127.0.0.1',NULL,NULL,NULL,'{\"method\": \"cod\", \"provider\": \"lbcx\"}',NULL,'next_day','box','pending','2018-08-16 09:09:09.000000',NULL,NULL,0),('2','0011-5246-CYKH','orders',NULL,'PH','{\"shipping_fee\": 140, \"insurance_fee\": 15, \"transaction_fee\": 35.5}',5000,'127.0.0.1',NULL,NULL,NULL,'{\"method\": \"cod\", \"provider\": \"lbcx\"}',NULL,'next_day','box','pending','2018-08-18 09:09:09.000000',NULL,NULL,1),('3','0012-5246-CYKH','orders',NULL,'PH','{\"shipping_fee\": 160, \"insurance_fee\": 20, \"transaction_fee\": 40.5}',15000,'127.0.0.1',NULL,NULL,NULL,'{\"method\": \"cod\", \"provider\": \"lbcx\"}',NULL,'next_day','box','pending','2018-08-20 09:09:09.000000',NULL,NULL,0),('4','0014-5246-CYKH','orders',NULL,'PH','{\"shipping_fee\": 190, \"insurance_fee\": 21, \"transaction_fee\": 60.5}',35000,'127.0.0.1',NULL,NULL,NULL,'{\"method\": \"cod\", \"provider\": \"lbcx\"}',NULL,'next_day','box','pending','2018-08-21 09:09:09.000000',NULL,NULL,1),('5','0015-5246-CYKH','orders',NULL,'PH','{\"shipping_fee\": 220, \"insurance_fee\": 23, \"transaction_fee\": 75.5}',55000,'127.0.0.1',NULL,NULL,NULL,'{\"method\": \"cod\", \"provider\": \"lbcx\"}',NULL,'next_day','box','pending','2018-08-21 09:09:09.000000',NULL,NULL,0),('6','0016-5246-CYKH','orders',NULL,'PH','{\"shipping_fee\": 250, \"insurance_fee\": 25, \"transaction_fee\": 85.5}',75000,'127.0.0.1',NULL,NULL,NULL,'{\"method\": \"cod\", \"provider\": \"lbcx\"}',NULL,'next_day','box','pending','2018-08-21 09:09:09.000000',NULL,NULL,1),('7','0017-5246-CYKH','orders',NULL,'PH','{\"shipping_fee\": 260, \"insurance_fee\": 28, \"transaction_fee\": 88.5}',80000,'127.0.0.1',NULL,NULL,NULL,'{\"method\": \"cod\", \"provider\": \"lbcx\"}',NULL,'next_day','box','pending','2018-08-21 09:09:09.000000',NULL,NULL,1),('8','0018-5246-CYKH','orders',NULL,'PH','{\"shipping_fee\": 260, \"insurance_fee\": 28, \"transaction_fee\": 88.5}',85000,'127.0.0.1',NULL,NULL,NULL,'{\"method\": \"cod\", \"provider\": \"lbcx\"}',NULL,'next_day','box','pending','2018-08-21 09:09:09.000000',NULL,NULL,0),('9','0020-5246-CYKH','orders',NULL,'PH','{\"shipping_fee\": 265, \"insurance_fee\": 29, \"transaction_fee\": 89.5}',89000,'127.0.0.1',NULL,NULL,NULL,'{\"method\": \"cod\", \"provider\": \"lbcx\"}',NULL,'next_day','box','pending','2018-08-21 09:09:09.000000',NULL,NULL,0);

INSERT INTO `qxma_pl_item` VALUES (1,'1','orders','LAPTOP',45000,1,50000.00,NULL,5000.00);

insert into `qxma_pl_breakdown`(`bd_id`,`payload_id`,`sub_total`,`shipping`,`tax`,`fee`,`insurance`,`discount`) values (1,'1',0.00,240.00,0.00,80.50,23.00,0.00);
insert into `qxma_pl_breakdown`(`bd_id`,`payload_id`,`sub_total`,`shipping`,`tax`,`fee`,`insurance`,`discount`) values (2,'2',0.00,140.00,0.00,35.50,15.00,0.00);
insert into `qxma_pl_breakdown`(`bd_id`,`payload_id`,`sub_total`,`shipping`,`tax`,`fee`,`insurance`,`discount`) values (3,'3',0.00,160.00,0.00,40.50,20.00,0.00);
insert into `qxma_pl_breakdown`(`bd_id`,`payload_id`,`sub_total`,`shipping`,`tax`,`fee`,`insurance`,`discount`) values (4,'4',0.00,190.00,0.00,60.50,21.00,0.00);
insert into `qxma_pl_breakdown`(`bd_id`,`payload_id`,`sub_total`,`shipping`,`tax`,`fee`,`insurance`,`discount`) values (5,'5',0.00,220.00,0.00,75.50,23.00,0.00);
insert into `qxma_pl_breakdown`(`bd_id`,`payload_id`,`sub_total`,`shipping`,`tax`,`fee`,`insurance`,`discount`) values (6,'6',0.00,250.00,0.00,85.50,25.00,0.00);
insert into `qxma_pl_breakdown`(`bd_id`,`payload_id`,`sub_total`,`shipping`,`tax`,`fee`,`insurance`,`discount`) values (7,'9',0.00,265.00,0.00,89.50,29.00,0.00);
insert into `qxma_pl_breakdown`(`bd_id`,`payload_id`,`sub_total`,`shipping`,`tax`,`fee`,`insurance`,`discount`) values (8,'8',0.00,260.00,0.00,85.50,28.00,0.00);
insert into `qxma_pl_breakdown`(`bd_id`,`payload_id`,`sub_total`,`shipping`,`tax`,`fee`,`insurance`,`discount`) values (9,'7',0.00,260.00,0.00,85.50,28.00,0.00);


insert into `qxma_dropoff_rates`(`dor_id`,`code`,`description`,`rates`) values (1,'MLhuillier Dropoff','Fee added for every MLhuillier Transactions',25.00);
insert into `qxma_dropoff_rates`(`dor_id`,`code`,`description`,`rates`) values (2,'ABC Dropoff','Fee added for every ABC Transactions',20.00);
insert into `qxma_dropoff_rates`(`dor_id`,`code`,`description`,`rates`) values (3,'PQR Dropoff','Fee added for every PQR Transactions',30.00);
insert into `qxma_dropoff_rates`(`dor_id`,`code`,`description`,`rates`) values (4,'XYZ Dropoff','Fee added for every XYZ Transactions',35.00);





