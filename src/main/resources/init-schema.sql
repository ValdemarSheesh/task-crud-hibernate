CREATE TABLE employee_project (
  employee_id BIGINT NOT NULL,
   project_id BIGINT NOT NULL
);

CREATE TABLE employees (
  id BIGINT NOT NULL,
   name VARCHAR(255),
   specialty_id BIGINT,
   CONSTRAINT pk_employees PRIMARY KEY (id)
);

CREATE TABLE projects (
  id BIGINT NOT NULL,
   nameProject VARCHAR(255),
   CONSTRAINT pk_projects PRIMARY KEY (id)
);

CREATE TABLE specialties (
  id BIGINT NOT NULL,
   nameSpecialty VARCHAR(255),
   CONSTRAINT pk_specialties PRIMARY KEY (id)
);

ALTER TABLE employees ADD CONSTRAINT FK_EMPLOYEES_ON_SPECIALTY FOREIGN KEY (specialty_id) REFERENCES specialties (id) ON DELETE SET NULL;

ALTER TABLE employee_project ADD CONSTRAINT fk_emppro_on_employee FOREIGN KEY (employee_id) REFERENCES employees (id) ON DELETE SET NULL;

ALTER TABLE employee_project ADD CONSTRAINT fk_emppro_on_project FOREIGN KEY (project_id) REFERENCES projects (id);