CREATE TABLE IF NOT EXISTS Position
(
    id       BIGSERIAL PRIMARY KEY,
    name     VARCHAR(100) NOT NULL,
    category VARCHAR(20)  NOT NULL
);

CREATE TABLE IF NOT EXISTS Project
(
    id          BIGSERIAL PRIMARY KEY,
    name        VARCHAR(50) NOT NULL,
    description VARCHAR(3000),
    start_date  TIMESTAMP   NOT NULL,
    finish_date TIMESTAMP
);

CREATE TABLE IF NOT EXISTS Country
(
    id       BIGSERIAL PRIMARY KEY,
    name     VARCHAR(100) NOT NULL,
    iso_code VARCHAR(20)  NOT NULL
);

CREATE TABLE IF NOT EXISTS City
(
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(100) NOT NULL,
    country_id INTEGER      NOT NULL REFERENCES Country
);

CREATE TABLE IF NOT EXISTS Office
(
    id      BIGSERIAL PRIMARY KEY,
    name    VARCHAR(50),
    address VARCHAR(500),
    zip     VARCHAR(10) NOT NULL,
    city_id INTEGER     NOT NULL REFERENCES City
);

CREATE TABLE IF NOT EXISTS Room
(
    id        BIGSERIAL PRIMARY KEY,
    floor     VARCHAR(15),
    number    VARCHAR(15),
    office_id INTEGER NOT NULL REFERENCES Office
);

CREATE TABLE IF NOT EXISTS Calendar
(
    id                 BIGSERIAL PRIMARY KEY,
    parent_calendar_id INTEGER REFERENCES Calendar
);

CREATE TABLE IF NOT EXISTS Event
(
    id          BIGSERIAL PRIMARY KEY,
    calendar_id INTEGER     NOT NULL REFERENCES Calendar,
    start_date  TIMESTAMP   NOT NULL,
    finish_date TIMESTAMP   NOT NULL,
    type        VARCHAR(50) NOT NULL,
    comment     VARCHAR(255),
    status      VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS Document
(
    id       BIGSERIAL PRIMARY KEY,
    event_id INTEGER      NOT NULL REFERENCES Event,
    label    VARCHAR(100) NOT NULL,
    path     VARCHAR(400) NOT NULL
);

CREATE TABLE IF NOT EXISTS Employee
(
    id               BIGSERIAL PRIMARY KEY,
    first_name       VARCHAR(100) NOT NULL,
    middle_name      VARCHAR(100),
    last_name        VARCHAR(100) NOT NULL,
    date_of_birth    TIMESTAMP    NOT NULL,
    email            VARCHAR(50),
    phone            VARCHAR(30),
    start_work_date  TIMESTAMP    NOT NULL,
    finish_work_date TIMESTAMP,
    department       VARCHAR(50),
    is_active        BOOLEAN      NOT NULL,
    room_id          INTEGER REFERENCES Room,
    calendar_id      INTEGER      NOT NULL REFERENCES Calendar,
    position_id      INTEGER      NOT NULL REFERENCES Position
);

CREATE TABLE IF NOT EXISTS Vacation_Request
(
    event_id    INTEGER     NOT NULL REFERENCES Event,
    manager_id  INTEGER     NOT NULL REFERENCES Employee,
    employee_id INTEGER     NOT NULL REFERENCES Employee,
    status      VARCHAR(50) NOT NULL,
    PRIMARY KEY (event_id, manager_id)
);

CREATE TABLE IF NOT EXISTS Employee_Manager_Map
(
    employee_id INTEGER NOT NULL REFERENCES Employee,
    manager_id  INTEGER NOT NULL REFERENCES Employee
);

CREATE TABLE IF NOT EXISTS Employee_Project_Map
(
    employee_id INTEGER NOT NULL REFERENCES Employee,
    project_id  INTEGER REFERENCES Project
);

CREATE TABLE IF NOT EXISTS Permission
(
    id     BIGSERIAL PRIMARY KEY,
    action VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS Role
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS Role_Permission_Map
(
    role_id       INTEGER NOT NULL REFERENCES Role,
    permission_id INTEGER NOT NULL REFERENCES Permission
);

CREATE TABLE IF NOT EXISTS Employee_Role_Map
(
    employee_id INTEGER NOT NULL REFERENCES Employee,
    role_id     INTEGER NOT NULL REFERENCES Role
);