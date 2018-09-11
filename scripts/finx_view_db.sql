create or replace view remittance_view as 
select qfc.order_id order_id,
qfr.created_at transaction_date,
qfr.bank_ref reference_number,
qfc.reference_id tracking_number,
'client',
qfr.amount_deposited amount,
qfc.tendered_amount matched_amount,
qfc.change_amount variance_amount,
qfcs.code order_status,
qfms.code match_status,
'payment_processor'
from qxma_ft_remittance qfr
left join qxma_ft_charges qfc on (qfr.reference_id = qfc.reference_id)
left join qxma_ft_charge_status qfcs on (qfc.charge_status_id = qfcs.cs_id)
left join qxma_ft_match_status qfms on (qfc.match_status_id = qfms.ms_id );