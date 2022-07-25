CREATE TABLE RE_Users (
	user_id BIGINT NOT NULL auto_increment,
	name VARCHAR(30) NOT NULL,
	surname VARCHAR(30) NOT NULL,
	email VARCHAR(100) NOT NULL,
	password VARCHAR(100) NOT NULL,

	CONSTRAINT users_PK PRIMARY KEY (user_id)
);

INSERT INTO RE_Users (name, surname, email, password)
VALUES (
        'Paolo',
        'Rossi',
        'admin@null.net',
        '$2a$12$CJb4FdIdPnDcNSjXrbkbMOBOPVXnDkB4cUEuDpamVEBWtbTFN77fy'
    ),
    (
        'Manuel',
        'Palumbo',
        'empee@null.net',
        '$2a$12$ujWaTB.TUkjBAfJKrckqxeTFGnBVf83v8Vp36ArPbcQ/0JbW7iI0C'
    );