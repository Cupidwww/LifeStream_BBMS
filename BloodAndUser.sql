-- 插入blood_bank_record表的数据
INSERT INTO blood_bank_record (id, blood_type, blood_category, blood_volume, transaction_date, expiration_date, blood_source, remarks) VALUES
(1, 'A+', 'Whole Blood', 450.0, '2023-06-01 09:30:00', '23:59:59', 'Volunteer Donation', 'Regular donor'),
(2, 'B-', 'Red Blood Cells', 200.0, '2023-06-02 14:15:00', '22:00:00', 'Blood Drive', 'First-time donor'),
(3, 'O+', 'Platelets', 50.0, '2023-06-03 11:00:00', '18:30:00', 'Hospital Collection', 'Collected during surgery'),
(4, 'AB-', 'Plasma', 300.0, '2023-06-04 16:45:00', '20:15:00', 'Apheresis Donation', 'Rare blood type'),
(5, 'A-', 'Whole Blood', 500.0, '2023-06-05 08:20:00', '23:59:59', 'Volunteer Donation', 'Regular donor'),  
(6, 'B+', 'Red Blood Cells', 180.0, '2023-06-06 13:10:00', '21:30:00', 'Mobile Blood Drive', 'High school blood drive'),
(7, 'O-', 'Whole Blood', 475.0, '2023-06-07 10:30:00', '23:00:00', 'Volunteer Donation', 'O- universal donor'),
(8, 'AB+', 'Platelets', 45.0, '2023-06-08 15:00:00', '19:45:00', 'Hospital Collection', 'Collected for specific patient'),
(9, 'A+', 'Plasma', 250.0, '2023-06-09 12:45:00', '22:30:00', 'Apheresis Donation', 'Convalescent plasma donation'),
(10, 'B-', 'Whole Blood', 500.0, '2023-06-10 09:00:00', '23:59:59', 'Volunteer Donation', 'Donated at community center');

-- 插入user表的数据
INSERT INTO user (id, username, password, role, employee_number, name, gender, age, phone, email, id_card, home_address) VALUES
(1, 'john_doe', 'password123', 'Admin', 'E001', 'John Doe', 'Male', 35, '1234567890', 'john@example.com', 'ID001', '123 Main St, City'),
(2, 'jane_smith', 'qwerty', 'User', 'E002', 'Jane Smith', 'Female', 28, '9876543210', 'jane@example.com', 'ID002', '456 Elm St, Town'),
(3, 'mike_johnson', 'abc123', 'Manager', 'E003', 'Mike Johnson', 'Male', 42, '5555555555', 'mike@example.com', 'ID003', '789 Oak Ave, Village'),
(4, 'sara_wilson', 'password456', 'User', 'E004', 'Sara Wilson', 'Female', 31, '1112223333', 'sara@example.com', 'ID004', '321 Pine Rd, City'),
(5, 'david_brown', 'letmein', 'Admin', 'E005', 'David Brown', 'Male', 45, '9998887777', 'david@example.com', 'ID005', '654 Cedar Ln, Town'),
(6, 'emily_davis', 'qazwsx', 'User', 'E006', 'Emily Davis', 'Female', 26, '4445556666', 'emily@example.com', 'ID006', '987 Birch St, Village'),
(7, 'chris_miller', 'password789', 'Manager', 'E007', 'Chris Miller', 'Male', 39, '7778889999', 'chris@example.com', 'ID007', '159 Maple Ave, City'),
(8, 'amanda_garcia', 'amanda123', 'User', 'E008', 'Amanda Garcia', 'Female', 33, '2223334444', 'amanda@example.com', 'ID008', '753 Walnut Rd, Town'), 
(9, 'kevin_rodriguez', 'kevin456', 'Admin', 'E009', 'Kevin Rodriguez', 'Male', 48, '6667778888', 'kevin@example.com', 'ID009', '951 Spruce Ln, Village'),
(10, 'olivia_martinez', 'password000', 'User', 'E010', 'Olivia Martinez', 'Female', 29, '3334445555', 'olivia@example.com', 'ID010', '147 Pineapple St, City');