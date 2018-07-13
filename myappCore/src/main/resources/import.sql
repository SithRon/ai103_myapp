// import.sql est un script SQL automatiquement déclenché par hibernate au démarrage de appli en mode hibernate.hbm2ddl.auto=create

INSERT INTO Client(numClient, prenom, nom, email, adresse, telephone, password) VALUES (1, 'BON', 'JOUR', 'bonjour@aurevoir.com', '45 rue des mamies mortes 75800', '01.01.01.01.01','pwd1')
INSERT INTO Client(numClient, prenom, nom, email, adresse, telephone, password) VALUES (2, 'SA', 'LUT', 'salut@porc.com', '30 avenue du cochon de lait 29000', '02.02.02.02.02','pwd2')