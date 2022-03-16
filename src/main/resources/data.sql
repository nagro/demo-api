DROP TABLE IF EXISTS drones;

CREATE TABLE drones (
  serial VARCHAR(250) PRIMARY KEY,
  model VARCHAR(250) default NULL,
  weight DOUBLE default NULL,
  battery_capacity DOUBLE default NULL,
  state TINYINT default NULL
);

INSERT INTO drones (serial,model,weight,battery_capacity,state)
VALUES
  ('3B7CXLJDED662-78EB-B4BB-493A-F7E8D5EA56DC','Middleweight',443,29,3),
  ('224PDN418BD-5E53-98EC-68C8-D69BAD567530','Middleweight.',87,18,0),
  ('2BDMS31B867-4CF8-353D-8798-EDB340AB8229','Cruiserweight',194,51,4),
  ('7DE8416C-EA49-D8E7-475E-D20AAD4CA2B1','Lightweight',421,16,3),
  ('BC9E154A-7B60-C7AC-3EB3-AA23B68BFDA9','Cruiserweight',469,77,0),
  ('98NF3DJ54A-7B60-C7AC-3EB3-AA23B68BFDA9','Heavyweight',469,107,0),
  ('4JZ0BC9E154A-7B60-C7AC-3EB3-AA23B68BFDA9','Lightweight',469,7,0),
  ('L9482HFO40154A-7B60-C7AC-3EB3-AA23B68BFDA9','Heavyweight',469,84,0),
  ('B39DNMDE154A-7B60-C7AC-3EB3-AA23B68BFDA9','Heavyweight',469,92,0);


DROP TABLE IF EXISTS medications;

CREATE TABLE medications (
  code VARCHAR(250) NOT NULL,
  name VARCHAR(250) default NULL,
  image TEXT default NULL,
  weight DOUBLE default NULL,
  PRIMARY KEY (code)
);

INSERT INTO medications (code,name,image,weight)
VALUES
  ('7CX3BLJ_F7E8D5EA56DC','medoc1','http://localhost/app/storage/img1',2.32),
  ('224PBAD5675DN418BD_5E5398EC_68C8-D6930','medoc2','http://localhost/app/storage/img2',0.68),
  ('675DAD5418BD_5E5398EC_68C8-D6930','medoc2','http://localhost/app/storage/img2',0.68),
  ('F8353D_8798B81B8_E0A67_4CDB3229','medoc_KhB94','http://localhost/app/storage/default',5.39),
  ('0N224PBAB7_4CF8353D81B86_8798_EDB3229','medoc_mxB0F3s0214','http://localhost/app/storage/default',3.4),
  ('1B86_87984PBAB7_4CF53D80D80N224P8353_EDN22B3229','medoc14','http://localhost/app/storage/img3',4.1),
  ('83BAB7_4CF1B86_8798_EDB3229','medoc_xB0F3s02m14','http://localhost/app/storage/img5',13.5);
