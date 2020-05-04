CREATE TABLE IF NOT EXISTS position
(
    id       BIGSERIAL PRIMARY KEY,
    name     VARCHAR(100) NOT NULL,
    category VARCHAR(20)  NOT NULL
);

CREATE TABLE IF NOT EXISTS project
(
    id          BIGSERIAL PRIMARY KEY,
    name        VARCHAR(50) NOT NULL,
    description VARCHAR(3000),
    start_date  TIMESTAMP   NOT NULL,
    finish_date TIMESTAMP
);

CREATE TABLE IF NOT EXISTS country
(
    id       BIGSERIAL PRIMARY KEY,
    name     VARCHAR(100) NOT NULL,
    iso_code VARCHAR(20)  NOT NULL
);

CREATE TABLE IF NOT EXISTS city
(
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(100) NOT NULL,
    country_id INTEGER      NOT NULL REFERENCES country
);

CREATE TABLE IF NOT EXISTS office
(
    id      BIGSERIAL PRIMARY KEY,
    name    VARCHAR(50),
    address VARCHAR(500),
    zip     VARCHAR(10) NOT NULL,
    city_id INTEGER     NOT NULL REFERENCES city
);

CREATE TABLE IF NOT EXISTS room
(
    id        BIGSERIAL PRIMARY KEY,
    floor     INTEGER NOT NULL,
    number    VARCHAR(15) NOT NULL,
    office_id INTEGER NOT NULL REFERENCES office
);

CREATE TABLE IF NOT EXISTS calendar
(
    id                 BIGSERIAL PRIMARY KEY,
    parent_calendar_id INTEGER REFERENCES calendar
);

CREATE TABLE IF NOT EXISTS event
(
    id          BIGSERIAL PRIMARY KEY,
    calendar_id INTEGER     NOT NULL REFERENCES calendar,
    start_date  TIMESTAMP   NOT NULL,
    finish_date TIMESTAMP   NOT NULL,
    type        VARCHAR(50) NOT NULL,
    comment     VARCHAR(255),
    status      VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS document
(
    id       BIGSERIAL PRIMARY KEY,
    event_id INTEGER      NOT NULL REFERENCES event,
    label    VARCHAR(100) NOT NULL,
    path     VARCHAR(400) NOT NULL
);

CREATE TABLE IF NOT EXISTS employee
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
    room_id          INTEGER REFERENCES room,
    calendar_id      INTEGER      NOT NULL REFERENCES calendar,
    position_id      INTEGER      NOT NULL REFERENCES position
);

CREATE TABLE IF NOT EXISTS vacation_request
(
    event_id    INTEGER     NOT NULL REFERENCES event,
    manager_id  INTEGER     NOT NULL REFERENCES employee,
    employee_id INTEGER     NOT NULL REFERENCES employee,
    status      VARCHAR(50) NOT NULL,
    PRIMARY KEY (event_id, manager_id)
);

CREATE TABLE IF NOT EXISTS employee_manager_map
(
    employee_id INTEGER NOT NULL REFERENCES employee,
    manager_id  INTEGER NOT NULL REFERENCES employee
);

CREATE TABLE IF NOT EXISTS employee_project_map
(
    employee_id INTEGER NOT NULL REFERENCES employee,
    project_id  INTEGER REFERENCES project
);

CREATE TABLE IF NOT EXISTS permission
(
    id     BIGSERIAL PRIMARY KEY,
    action VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS role
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS role_permission_map
(
    role_id       INTEGER NOT NULL REFERENCES role,
    permission_id INTEGER NOT NULL REFERENCES permission
);

CREATE TABLE IF NOT EXISTS employee_role_map
(
    employee_id INTEGER NOT NULL REFERENCES employee,
    role_id     INTEGER NOT NULL REFERENCES role
);