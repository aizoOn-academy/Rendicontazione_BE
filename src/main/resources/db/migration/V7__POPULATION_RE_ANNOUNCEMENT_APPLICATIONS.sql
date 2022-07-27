INSERT INTO RE_AnnouncementApplications(announcement_application_id,operator_id,announcement_id,
                                        applicant_fiscal_code,applicant_name,applicant_surname,applicant_address,
                                        applicant_city_cap,applicant_city,applicant_nation,applicant_phone,
                                        money_amount,applicant_iban,note)
VALUES
(
    '1','1','1',
    'MNCMTT92A19A001Y','Matteo','Moncalvo','via berta 5',
    '10095','Torino','Italia',
    '3378341326','5000',
    'IT60X0542811101000000123456', NULL
),
(
    '2','1','2',
    'CMPNCL80M65A029Z','Nicole','Campbell','queen street park 25',
    '11085','London','England',
    '6778341326','20000',
    'EN60X0642811101000000123477','visually impaired person requesting social assistance'
),
(
    '3','1','2',
    'LBCRS90E25E606O','Christian','Louboutain','rue curial 19',
    '15023','Paris','France',
    '9778341327','10000',
    'FR60X0342811501000000123417','entrepreneur dans urgence sociale'
);

