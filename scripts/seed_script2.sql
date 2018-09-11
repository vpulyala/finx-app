
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

insert into qxma_ft_payment_method values(10, 'CASH');
insert into qxma_ft_payment_method values(20, 'CREDITCARD/DEBITCARD');
insert into qxma_ft_payment_method values(30, 'DRAGONPAY');
insert into qxma_ft_payment_method values(40, 'PREPAYMENT');
insert into qxma_ft_payment_method values(50, 'REVOLVING FUND');
insert into qxma_ft_payment_method values(60, 'NON CASH');
insert into qxma_ft_payment_method values(70, 'PAYPAL');

--
-- Organization
--
insert into qxma_organization(org_code, name) values('10000','QUADX');

-- 
-- Legal Entity
--
insert into qxma_legal_entity(code,org_code,name) values('11', '10000', 'QUADX Inc.');
insert into qxma_legal_entity(code,org_code,name) values('12', '10000', 'QUADX PTE Ltd.');

--
-- Product
--
insert into qxma_product(code,name) values('101','CHECKMEOUT');
insert into qxma_product(code,name) values('102','XPOST');
insert into qxma_product(code,name) values('103','SHOPEE');
insert into qxma_product(code,name) values('201','SHIPPING CART');

-- 
-- Payment Method
--
insert into qxma_payment_method(code,name) values('10','CASH');
insert into qxma_payment_method(code,name) values('20','CREDITCARD/DEBITCARD');
insert into qxma_payment_method(code,name) values('30','DRAGONPAY');
insert into qxma_payment_method(code,name) values('40','PREPAYMENT');
insert into qxma_payment_method(code,name) values('50','REVOLVING FUND');
insert into qxma_payment_method(code,name) values('60','NON CASH');
insert into qxma_payment_method(code,name) values('70','PAYPAL');

--
-- Service Provider
--
insert into qxma_service_provider(code, name) values('10','3PL');
insert into qxma_service_provider(code, name) values('20','QUADX');

-- 
-- Service Type
--
insert into qxma_service_type(code, name) values('10','LOGISTICS');
insert into qxma_service_type(code, name) values('20','PAYMENT');
insert into qxma_service_type(code, name) values('30','BOTH');
--
-- Account Type
--
insert into qxma_account_type(code, name) values('10', 'PREPAID');
insert into qxma_account_type(code, name) values('20', 'POSTPAID');
insert into qxma_account_type(code, name) values('30', 'NET ACCOUNT');
insert into qxma_account_type(code, name) values('40', 'OTHER COUNTRIES');

--
-- Accounts
--
insert into qxma_account(code, name) values('111003','Revolving Fund-CS');	
insert into qxma_account(code, name) values('111004','Undeposited Collection');	
insert into qxma_account(code, name) values('111005','Revolving Fund-SC');	
insert into qxma_account(code, name) values('113900','Cash Clearing Account');	
insert into qxma_account(code, name) values('117101','Accounts Receivable');	
insert into qxma_account(code, name) values('117104','Claims Receivable');	
insert into qxma_account(code, name) values('117105','Merchant Receivable');	
insert into qxma_account(code, name) values('117107','Asiapay - 270784950');	
insert into qxma_account(code, name) values('117108','Asiapay - 272362648');	
insert into qxma_account(code, name) values('117109','Adyen');	
insert into qxma_account(code, name) values('117110','COD-LBC');	 
insert into qxma_account(code, name) values('117111','Dragonpay');	
insert into qxma_account(code, name) values('117115','Paypal - PH USD-9TBJDBFUL879Q');	
insert into qxma_account(code, name) values('117116','Paypal - SG USD-Z3ZDVQKASALA');	
insert into qxma_account(code, name) values('117900','Unbilled Receivable');	
insert into qxma_account(code, name) values('119007','Input Tax');	
insert into qxma_account(code, name) values('119008','Creditable Wtax');	
insert into qxma_account(code, name) values('119010','Deferred Input Tax');	
insert into qxma_account(code, name) values('400001','Transaction Fee - Shipping');	
insert into qxma_account(code, name) values('400002','Transaction Fee - Insurance');	
insert into qxma_account(code, name) values('400003','Transaction Fee - Collection Fee');	
insert into qxma_account(code, name) values('400004','Shipping Cart - Shipping');	
insert into qxma_account(code, name) values('400005','Shipping Cart - Insurance');	
insert into qxma_account(code, name) values('400006','Shipping Cart - Storage');	
insert into qxma_account(code, name) values('400007','Sales Refund');	
insert into qxma_account(code, name) values('400008','Sales Discount');	
insert into qxma_account(code, name) values('400009','Transaction Fee - Drop off Fee');	
insert into qxma_account(code, name) values('400010','Transaction Fee - Return Fee');	
insert into qxma_account(code, name) values('400011','Shipping Cart - Shipping-Sea');	
insert into qxma_account(code, name) values('511001','Bank Fee');	
insert into qxma_account(code, name) values('511010','Shipping Cost - Drop Off');	
insert into qxma_account(code, name) values('511060','COS – Claims');	
insert into qxma_account(code, name) values('511901','COS - Claims Clearing Account');	
insert into qxma_account(code, name) values('515569','COS - Dispute Losses');	
insert into qxma_account(code, name) values('211005','Merchant Payable');	
insert into qxma_account(code, name) values('211900','Merchant Payable Clearing');	
insert into qxma_account(code, name) values('213003','Customer Deposit - RF');	
insert into qxma_account(code, name) values('213016','Customer Deposit - CMO');	
insert into qxma_account(code, name) values('213011','VAT Payable');	
insert into qxma_account(code, name) values('213012','Output VAT');	
insert into qxma_account(code, name) values('213014','Deferred Revenue');	
insert into qxma_account(code, name) values('213017','Donation Payable');	
insert into qxma_account(code, name) values('211004','Claims Payable');	
--
-- OMS Events/Transaction Status
-- 
insert into qxma_oms_event_status(code, name) values('pending', 'pending');
insert into qxma_oms_event_status(code, name) values('for_pickup', 'for_pickup'); 
insert into qxma_oms_event_status(code, name) values('picked_up', 'picked_up');
insert into qxma_oms_event_status(code, name) values('failed_pickup', 'failed_pickup');
insert into qxma_oms_event_status(code, name) values('in_transit', 'in_transit');
insert into qxma_oms_event_status(code, name) values('claimed', 'claimed');
insert into qxma_oms_event_status(code, name) values('out_for_delivery', 'out_for_delivery');
insert into qxma_oms_event_status(code, name) values('delivered', 'delivered');
insert into qxma_oms_event_status(code, name) values('failed_delivery', 'failed_delivery');
insert into qxma_oms_event_status(code, name) values('return_in_transit', 'return_in_transit');
insert into qxma_oms_event_status(code, name) values('returned', 'returned');
insert into qxma_oms_event_status(code, name) values('failed_return', 'failed_return');
insert into qxma_oms_event_status(code, name) values('confirmed', 'confirmed');
insert into qxma_oms_event_status(code, name) values('canceled', 'canceled');
insert into qxma_oms_event_status(code, name) values('for_dropoff', 'for_dropoff');
insert into qxma_oms_event_status(code, name) values('dropped_off', 'dropped_off');
insert into qxma_oms_event_status(code, name) values('consolidated', 'consolidated');
insert into qxma_oms_event_status(code, name) values('for_transfer', 'for_transfer');
insert into qxma_oms_event_status(code, name) values('for_acceptance', 'for_acceptance');
insert into qxma_oms_event_status(code, name) values('accepted', 'accepted');
insert into qxma_oms_event_status(code, name) values('payment_only', 'Payment only');
insert into qxma_oms_event_status(code, name) values('mlhuillier_dropoff', 'MLhuillier Dropoff');

--
-- Financial Tools Event/Transaction Status
--
insert into qxma_ft_event_status(code, name) values('RF_Top_Up','RF Top Up');
insert into qxma_ft_event_status(code, name) values('Remittance_AsiaPay','Remittance - AsiaPay');
insert into qxma_ft_event_status(code, name) values('Remittance_LBC','Remittance - LBC');
insert into qxma_ft_event_status(code, name) values('Remittance_QuadX','Remittance - QuadX');
insert into qxma_ft_event_status(code, name) values('Remittance_Dragonpay','Remittance - Dragonpay');
insert into qxma_ft_event_status(code, name) values('Remittance_Adyen','Remittance - Adyen');
insert into qxma_ft_event_status(code, name) values('DISBURSAL','DISBURSAL');
insert into qxma_ft_event_status(code, name) values('TRANSFER','TRANSFER');

--
-- FinX Event Status
--
insert into qxma_finx_event_status(code, name) values('DISALLOWED_REVENUE','DISALLOWED REVENUE');
insert into qxma_finx_event_status(code, name) values('COLLECTION','COLLECTION');
insert into qxma_finx_event_status(code, name) values('DR_RECOVERY','DR RECOVERY');

