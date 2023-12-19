CREATE DATABASE if not exists StudentManagement default character set utf8mb4 collate utf8mb4_general_ci;

USE StudentManagement;

CREATE TABLE if not exists user
(
    userID       int(11)      NOT NULL,
    username     varchar(255) NOT NULL,
    userEmail    varchar(255) NOT NULL,
    userRole     varchar(255) NOT NULL,
    userPassword varchar(255) NOT NULL,
    PRIMARY KEY (userID)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;

INSERT INTO user (userID, username, userEmail, userRole, userPassword)
VALUES (1, 'admin', 'admin@gmail.com', 'admin', 'admin');

INSERT INTO user (userID, username, userEmail, userRole, userPassword)
VALUES (2, 'JohnSmith', 'johnsmith@gmail.com', 'student', 'johnsmith'),
       (3, 'JaneSmith', 'janesmith@gmail.com', 'student', 'janesmith'),
       (4, 'JohnDoe', 'johndoe@gmail.com', 'student', 'johndoe'),
       (5, 'AliceJohnson', 'alicejohnson@gmail.com', 'student', 'alicejohnson'),
       (6, 'BobWilliams', 'bobwilliams@gmail.com', 'student', 'bobwilliams'),
       (7, 'CharlieBrown', 'charliebrown@gmail.com', 'student', 'charliebrown'),
       (8, 'DavidJones', 'davidjones@gmail.com', 'student', 'davidjones'),
       (9, 'EveDavis', 'evedavis@gmail.com', 'student', 'evedavis'),
       (10, 'FrankMiller', 'frankmiller@gmail.com', 'student', 'frankmiller'),
       (11, 'GraceWilson', 'gracewilson@gmail.com', 'student', 'gracewilson'),
       (12, 'HarryMoore', 'harrymoore@gmail.com', 'student', 'harrymoore'),
       (13, 'IvyTaylor', 'ivytaylor@gmail.com', 'student', 'ivytaylor'),
       (14, 'JackAnderson', 'jackanderson@gmail.com', 'student', 'jackanderson');

INSERT INTO user (userID, username, userEmail, userRole, userPassword)
VALUES (15, 'ProfJames', 'profjames@gmail.com', 'professor', 'profjames'),
       (16, 'ProfEmma', 'profemma@gmail.com', 'professor', 'profemma'),
       (17, 'ProfOliver', 'profolver@gmail.com', 'professor', 'profolver'),
       (18, 'ProfSophia', 'profsophia@gmail.com', 'professor', 'profsophia'),
       (19, 'ProfLiam', 'profliam@gmail.com', 'professor', 'profliam'),
       (20, 'ProfAva', 'profava@gmail.com', 'professor', 'profava');

CREATE TABLE if not exists student
(
    studentID          int(11)      NOT NULL,
    userID             int(11)      NOT NULL,
    studentFirstName   varchar(255) NOT NULL,
    studentLastName    varchar(255) NOT NULL,
    studentEmail       varchar(255) NOT NULL,
    studentPhone       varchar(255) NOT NULL,
    studentAddress     varchar(255) NOT NULL,
    studentDOB         varchar(255) NOT NULL,
    studentGender      varchar(255) NOT NULL,
    studentMajor       varchar(255) NOT NULL,
    PRIMARY KEY (studentID),
    FOREIGN KEY (userID) REFERENCES user (userID)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;

INSERT INTO student (studentID, userID, studentFirstName, studentLastName, studentEmail, studentPhone, studentAddress,
                     studentDOB, studentGender, studentMajor)
VALUES (1, 2, 'John', 'Smith', 'johnsmith@gmail.com', '123-456-7890', '123 Main St', '1990-01-15', 'Male',
        'Computer Science'),
       (2, 3, 'Jane', 'Smith', 'janesmith@gmail.com', '234-567-8901', '456 Oak St', '1992-05-22', 'Female', 'Biology'
        ),
       (3, 4, 'John', 'Doe', 'johndoe@gmail.com', '345-678-9012', '789 Pine St', '1988-11-08', 'Male', 'Mathematics'),
       (4, 5, 'Alice', 'Johnson', 'alicejohnson@gmail.com', '456-789-0123', '101 Elm St', '1995-03-30', 'Female',
        'Physics'),
       (5, 6, 'Bob', 'Williams', 'bobwilliams@gmail.com', '567-890-1234', '202 Cedar St', '1993-08-18', 'Male',
        'Chemistry'),
       (6, 7, 'Charlie', 'Brown', 'charliebrown@gmail.com', '678-901-2345', '303 Maple St', '1997-04-12', 'Male',
        'English Literature'),
       (7, 8, 'David', 'Jones', 'davidjones@gmail.com', '789-012-3456', '404 Birch St', '1994-09-25', 'Male', 'History'),
       (8, 9, 'Eve', 'Davis', 'evedavis@gmail.com', '890-123-4567', '505 Walnut St', '1996-01-03', 'Female',
        'Psychology'),
       (9, 10, 'Frank', 'Miller', 'frankmiller@gmail.com', '901-234-5678', '606 Pine St', '1991-07-14', 'Male',
        'Political Science'),
       (10, 11, 'Grace', 'Wilson', 'gracewilson@gmail.com', '012-345-6789', '707 Oak St', '1998-12-09', 'Female',
        'Sociology'),
       (11, 12, 'Harry', 'Moore', 'harrymoore@gmail.com', '123-456-7890', '808 Maple St', '1999-06-28', 'Male',
        'Economics'),
       (12, 13, 'Ivy', 'Taylor', 'ivytaylor@gmail.com', '234-567-8901', '909 Cedar St', '1990-02-17', 'Female',
        'Anthropology'),
       (13, 14, 'Jack', 'Anderson', 'jackanderson@gmail.com', '345-678-9012', '1011 Elm St', '1993-10-05', 'Male',
        'Geology');

CREATE TABLE if not exists professor
(
    professorID         int(11)      NOT NULL,
    userID              int(11)      NOT NULL,
    professorFirstName  varchar(255) NOT NULL,
    professorLastName   varchar(255) NOT NULL,
    professorEmail      varchar(255) NOT NULL,
    professorPhone      varchar(255) NOT NULL,
    professorAddress    varchar(255) NOT NULL,
    professorDOB        varchar(255) NOT NULL,
    professorGender     varchar(255) NOT NULL,
    professorDepartment varchar(255) NOT NULL,
    PRIMARY KEY (professorID),
    FOREIGN KEY (userID) REFERENCES user (userID)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;

INSERT INTO professor (professorID, userID, professorFirstName, professorLastName, professorEmail, professorPhone,
                       professorAddress, professorDOB, professorGender, professorDepartment)
VALUES (1, 15, 'James', 'Smith', 'profjames@gmail.com', '123-456-7890', '123 Main St', '1965-08-12', 'Male',
        'Computer Science'),
       (2, 16, 'Emma', 'Johnson', 'profemma@gmail.com', '234-567-8901', '456 Oak St', '1972-03-25', 'Female',
        'Biology'),
       (3, 17, 'Oliver', 'Doe', 'profolver@gmail.com', '345-678-9012', '789 Pine St', '1968-11-18', 'Male',
        'Mathematics'),
       (4, 18, 'Sophia', 'Anderson', 'profsophia@gmail.com', '456-789-0123', '101 Elm St', '1975-05-30', 'Female',
        'Physics'),
       (5, 19, 'Liam', 'Williams', 'profliam@gmail.com', '567-890-1234', '202 Cedar St', '1970-10-08', 'Male',
        'Chemistry'),
       (6, 20, 'Ava', 'Moore', 'profava@gmail.com', '678-901-2345', '303 Maple St', '1967-04-22', 'Female',
        'English Literature');

CREATE TABLE if not exists course
(
    courseID          int(11)      NOT NULL,
    courseName        varchar(255) NOT NULL,
    courseDescription varchar(255) NOT NULL,
    courseCredit      varchar(255) NOT NULL,
    courseDay         varchar(255) NOT NULL,
    courseTime        varchar(255) NOT NULL,
    courseRoom        varchar(255) NOT NULL,
    PRIMARY KEY (courseID)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;

INSERT INTO course (courseID, courseName, courseDescription, courseCredit, courseDay, courseTime, courseRoom)
VALUES
    (1, 'Introduction to Computer Science', 'Fundamentals of programming and problem-solving', '3', 'Monday', '10:00 AM - 12:00 PM', 'Room 101'),
    (2, 'Biology 101', 'Basic concepts of biology and life sciences', '4', 'Wednesday', '2:00 PM - 4:00 PM', 'Room 201'),
    (3, 'Mathematics for Engineers', 'Mathematical concepts for engineering applications', '3', 'Tuesday', '9:00 AM - 11:00 AM', 'Room 301'),
    (4, 'Physics Fundamentals', 'Principles of classical physics', '4', 'Thursday', '1:00 PM - 3:00 PM', 'Room 401'),
    (5, 'Organic Chemistry', 'Study of organic compounds and reactions', '3', 'Friday', '3:00 PM - 5:00 PM', 'Room 501'),
    (6, 'English Literature Survey', 'Overview of major works in English literature', '3', 'Monday', '1:00 PM - 3:00 PM', 'Room 601'),
    (7, 'Web Development Basics', 'Introduction to web development technologies', '3', 'Wednesday', '10:00 AM - 12:00 PM', 'Room 102'),
    (8, 'Data Structures and Algorithms', 'Advanced programming concepts', '4', 'Tuesday', '2:00 PM - 4:00 PM', 'Room 202'),
    (9, 'Biochemistry Principles', 'Understanding biochemical processes', '3', 'Thursday', '9:00 AM - 11:00 AM', 'Room 302'),
    (10, 'Calculus II', 'Advanced calculus topics', '4', 'Friday', '1:00 PM - 3:00 PM', 'Room 402'),
    (11, 'Inorganic Chemistry', 'Study of inorganic compounds', '3', 'Monday', '3:00 PM - 5:00 PM', 'Room 502'),
    (12, 'British Literature Classics', 'Exploring classic British literature', '3', 'Wednesday', '1:00 PM - 3:00 PM', 'Room 602'),
    (13, 'Machine Learning Fundamentals', 'Introduction to machine learning concepts', '4', 'Tuesday', '10:00 AM - 12:00 PM', 'Room 103'),
    (14, 'Database Management Systems', 'Managing and querying databases', '3', 'Thursday', '2:00 PM - 4:00 PM', 'Room 203'),
    (15, 'Molecular Biology', 'Understanding molecular processes in living organisms', '4', 'Friday', '9:00 AM - 11:00 AM', 'Room 303'),
    (16, 'Linear Algebra', 'Advanced algebraic concepts and applications', '3', 'Monday', '1:00 PM - 3:00 PM', 'Room 403'),
    (17, 'Physical Chemistry', 'Study of physical properties and changes in matter', '4', 'Wednesday', '3:00 PM - 5:00 PM', 'Room 503'),
    (18, 'American Literature Survey', 'Exploring major works in American literature', '3', 'Tuesday', '1:00 PM - 3:00 PM', 'Room 603'),
    (19, 'Artificial Intelligence Applications', 'Practical applications of AI technologies', '4', 'Thursday', '10:00 AM - 12:00 PM', 'Room 104'),
    (20, 'Network Security', 'Securing computer networks and data', '3', 'Friday', '2:00 PM - 4:00 PM', 'Room 204');

CREATE TABLE if not exists class(
    classID int(11) NOT NULL,
    courseID int(11) NOT NULL,
    professorID int(11) NOT NULL,
    startDate varchar(255) NOT NULL,
    endDate varchar(255) NOT NULL,
    slots int(11) NOT NULL,
    availableSlots int(11) NOT NULL,

    PRIMARY KEY (classID),
    FOREIGN KEY (courseID) REFERENCES course (courseID),
    FOREIGN KEY (professorID) REFERENCES professor (professorID)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;

INSERT INTO class (classID, courseID, professorID, startDate, endDate, slots, availableSlots)
VALUES
    (1, 1, 1, '2023-01-10', '2023-05-15', 30, 30),
    (2, 2, 2, '2023-02-15', '2023-06-20', 25, 25),
    (3, 3, 3, '2023-01-20', '2023-05-25', 20, 20),
    (4, 4, 4, '2023-03-01', '2023-07-05', 35, 35),
    (5, 5, 5, '2023-02-10', '2023-06-15', 30, 30),
    (6, 6, 6, '2023-01-15', '2023-05-20', 25, 25),
    (7, 7, 1, '2023-03-15', '2023-07-20', 20, 20),
    (8, 8, 2, '2023-02-20', '2023-06-25', 35, 35),
    (9, 9, 3, '2023-01-25', '2023-05-30', 30, 30),
    (10, 10, 4, '2023-03-10', '2023-07-15', 25, 25),
    (11, 11, 5, '2023-02-15', '2023-06-20', 20, 20),
    (12, 12, 6, '2023-01-20', '2023-05-25', 35, 35),
    (13, 13, 1, '2023-03-01', '2023-07-05', 30, 30),
    (14, 14, 2, '2023-02-10', '2023-06-15', 25, 25),
    (15, 15, 3, '2023-01-15', '2023-05-20', 20, 20),
    (16, 16, 4, '2023-03-15', '2023-07-20', 35, 35),
    (17, 17, 5, '2023-02-20', '2023-06-25', 30, 30),
    (18, 18, 6, '2023-01-25', '2023-05-30', 25, 25),
    (19, 19, 1, '2023-03-10', '2023-07-15', 20, 20),
    (20, 20, 2, '2023-02-15', '2023-06-20', 35, 35);

CREATE TABLE if not exists enrollment(
    enrollmentID int(11) NOT NULL,
    studentID int(11) NOT NULL,
    classID int(11) NOT NULL,
    score int(11) NOT NULL,
    PRIMARY KEY (enrollmentID),
    FOREIGN KEY (studentID) REFERENCES student (studentID),
    FOREIGN KEY (classID) REFERENCES class (classID)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;

INSERT INTO enrollment (enrollmentID, studentID, classID, score)
VALUES
    (1, 1, 1, 100),
    (2, 2, 2, 45),
    (3, 3, 3, 84),
    (4, 4, 4, 63),
    (5, 5, 5, 78),
    (6, 6, 6, 84),
    (7, 7, 7, 12),
    (8, 8, 8, 69),
    (9, 9, 9, 81),
    (10, 10, 10, 88),
    (11, 11, 11, 95),
    (12, 12, 12, 61),
    (13, 13, 13, 78);


CREATE TABLE if not exists scholarship
(
    scholarshipID          int(11)      NOT NULL,
    scholarshipName        varchar(255) NOT NULL,
    scholarshipDescription varchar(255) NOT NULL,
    PRIMARY KEY (scholarshipID)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;

INSERT INTO scholarship (scholarshipID, scholarshipName, scholarshipDescription)
VALUES
    (1, 'Merit Scholarship', 'Awarded based on academic excellence'),
    (2, 'Need-Based Scholarship', 'Awarded based on financial need'),
    (3, 'Leadership Scholarship', 'Awarded for demonstrated leadership skills'),
    (4, 'STEM Scholarship', 'Awarded to students in science, technology, engineering, and mathematics fields'),
    (5, 'Arts and Humanities Scholarship', 'Awarded to students in arts and humanities disciplines'),
    (6, 'Athletic Scholarship', 'Awarded to student-athletes for sports achievements'),
    (7, 'Diversity Scholarship', 'Awarded to promote diversity and inclusion'),
    (8, 'Community Service Scholarship', 'Awarded for outstanding community service contributions'),
    (9, 'Global Engagement Scholarship', 'Awarded to students with a strong commitment to global issues'),
    (10, 'Entrepreneurship Scholarship', 'Awarded to students with entrepreneurial achievements');

CREATE TABLE if not exists student_scholarship
(
    studentScholarshipID int(11) NOT NULL,
    studentID            int(11) NOT NULL,
    scholarshipID        int(11) NOT NULL,
    PRIMARY KEY (studentScholarshipID),
    FOREIGN KEY (studentID) REFERENCES student (studentID),
    FOREIGN KEY (scholarshipID) REFERENCES scholarship (scholarshipID)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;

INSERT INTO student_scholarship (studentScholarshipID, studentID, scholarshipID)
VALUES (1, 1, 1),
       (2, 2, 2),
       (3, 3, 3),
       (4, 4, 4),
       (5, 5, 5),
       (6, 6, 6),
       (7, 7, 7),
       (8, 8, 8),
       (9, 9, 9);

INSERT INTO student_scholarship (studentScholarshipID, studentID, scholarshipID)
VALUES (10, 10, 10),
       (15, 1, 5),
       (16, 2, 6),
       (17, 3, 7),
       (18, 4, 8),
       (19, 5, 9),
       (20, 6, 10);

CREATE TABLE if not exists tuition
(
    tuitionID       int(11)      NOT NULL,
    tuitionAmount   int(11) NOT NULL,
    tuitionDeadline varchar(255) NOT NULL,
    studentID       int(11)      NOT NULL,
    tuitionStatus   varchar(255) NOT NULL,
    tuitionSemester int(11) NOT NULL,
    PRIMARY KEY (tuitionID),
    FOREIGN KEY (studentID) REFERENCES student (studentID)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;

INSERT INTO tuition (tuitionID, tuitionAmount, tuitionDeadline, studentID, tuitionStatus, tuitionSemester)
VALUES (1, 1000, '2023-01-15', 1, 'Paid', 1),
       (2, 1000, '2023-01-15', 2, 'Paid', 1),
       (3, 1000, '2023-01-15', 3, 'Paid', 1),
       (4, 1000, '2023-01-15', 4, 'Paid', 1),
       (5, 1000, '2023-01-15', 5, 'Paid', 1),
       (6, 1000, '2023-01-15', 6, 'Paid', 1),
       (7, 1000, '2023-01-15', 7, 'Paid', 1),
       (8, 1000, '2023-01-15', 8, 'Paid', 1),
       (9, 1000, '2023-01-15', 9, 'Paid', 1),
       (10, 1000, '2023-01-15', 10, 'Paid', 1),
       (11, 1000, '2023-01-15', 11, 'Paid', 1),
       (12, 1000, '2023-01-15', 12, 'Paid', 1),
       (13, 1000, '2023-01-15', 13, 'Paid', 1);

CREATE TABLE if not exists admin (
    adminID int(11) NOT NULL,
    userID int(11) NOT NULL,
    adminFirstName varchar(255) NOT NULL,
    adminLastName varchar(255) NOT NULL,
    adminEmail varchar(255) NOT NULL,
    adminPhone varchar(255) NOT NULL,
    adminAddress varchar(255) NOT NULL,
    adminDOB varchar(255) NOT NULL,
    adminGender varchar(255) NOT NULL,
    PRIMARY KEY (adminID),
    FOREIGN KEY (userID) REFERENCES user (userID)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;

INSERT INTO admin (adminID, userID, adminFirstName, adminLastName, adminEmail, adminPhone, adminAddress, adminDOB, adminGender)
VALUES
    (1, 1, 'John', 'Doe', 'john.doe@example.com', '123-456-7890', '123 Main St', '1990-01-01', 'Male');
