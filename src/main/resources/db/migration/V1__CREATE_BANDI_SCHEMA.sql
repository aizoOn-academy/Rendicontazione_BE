CREATE TABLE TRA_Bandi (
	bando_id BIGINT NOT NULL auto_increment,
	codice VARCHAR(32) NOT NULL,
	descrizione VARCHAR(256),
	data_inizio DATE,
	data_fine DATE,

	CONSTRAINT bandi_PK PRIMARY KEY (bando_id)
);

