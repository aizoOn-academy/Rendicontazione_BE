CREATE TABLE RE_Announcements (
    announcement_id BIGINT auto_increment,
    code VARCHAR(32) NOT NULL,
    title VARCHAR(30) NOT NULL,
    description TEXT NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    PRIMARY KEY (announcement_id)
);