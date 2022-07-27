CREATE TABLE RE_Requests (
	request_id BIGINT NOT NULL,
	operator_id BIGINT NOT NULL,
	announcment_id BIGINT NOT NULL,
	applicant_fiscal_code VARCHAR(16) NOT NULL,
	applicant_name VARCHAR(30) NOT NULL,
	applicant_surname VARCHAR(30) NOT NULL,
	applicant_address VARCHAR(50) NOT NULL,
	applicant_city_cap VARCHAR(5) NOT NULL,
	applicant_city VARCHAR(30) NOT NULL,
	applicant_nation VARCHAR(30) NOT NULL,
	applicant_phone VARCHAR(10) NOT NULL,
	money_amount FLOAT NOT NULL,
	applicant_iban VARCHAR(27) NOT NULL,
	note TEXT NULL,

	approvation_status BOOLEAN NULL,
	money_amount_final FLOAT NULL,

	CONSTRAINT request_PK PRIMARY KEY (request_id),

	CONSTRAINT operator_FK FOREIGN KEY (operator_id)
	REFERENCES RE_Operators(operator_id)
)