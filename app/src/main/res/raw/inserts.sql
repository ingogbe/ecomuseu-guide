
INSERT INTO Language (id, language, countryCode) VALUES (1,"pt","BR");
INSERT INTO Language (id, language, countryCode) VALUES (2,"en","US");

INSERT INTO Room (id, coverImageSrc, mapIdentification) VALUES (1, 'ecomuseu1', 'rodaDagua');
INSERT INTO Room (id, coverImageSrc, mapIdentification) VALUES (2, 'ecomuseu2', 'carrocaoCarroBoi');
INSERT INTO Room (id, coverImageSrc, mapIdentification) VALUES (3, 'ecomuseu3', 'exposicoesHall');
INSERT INTO Room (id, coverImageSrc, mapIdentification) VALUES (4, 'ecomuseu4', 'historiaUsina');

INSERT INTO Achievement (id, points, idRoom) VALUES (1, 50, 1);
INSERT INTO Achievement (id, points, idRoom) VALUES (2, 100, 2);
INSERT INTO Achievement (id, points, idRoom) VALUES (3, 70, 3);
INSERT INTO Achievement (id, points, idRoom) VALUES (4, 60, 4);

INSERT INTO RoomLanguage (id, idRoom, idLanguage, name, description) VALUES (1,1,1, "Roda D Água", "Nessa pode-se observar uma roda d'água.");
INSERT INTO RoomLanguage (id, idRoom, idLanguage, name, description) VALUES (2,2,1, 'Carroção', 'Essa sala possui um carroçã e um carro de boi.');
INSERT INTO RoomLanguage (id, idRoom, idLanguage, name, description) VALUES (3,3,1, 'Hall de Exposições', 'Nessa sala é possível encontrar diversas exposições');
INSERT INTO RoomLanguage (id, idRoom, idLanguage, name, description) VALUES (4,4,1, 'História da Usina Hidrelétrica', 'Essa sala é composta por exposições sobre a história da usina');

INSERT INTO RoomLanguage (id, idRoom, idLanguage, name, description) VALUES (5,1,2, 'Water Wheel', 'This is room 1');
INSERT INTO RoomLanguage (id, idRoom, idLanguage, name, description) VALUES (6,2,2, 'Wagon', 'This is room 2');
INSERT INTO RoomLanguage (id, idRoom, idLanguage, name, description) VALUES (7,3,2, 'Expositions Hall', 'This is room 3');
INSERT INTO RoomLanguage (id, idRoom, idLanguage, name, description) VALUES (8,4,2, 'History of Hydroelectric Plant', 'This is room 4');

INSERT INTO Exposition (id, name, description, coverImageSrc, qrCodeLink, idRoomLanguage) VALUES (1, 'Exposição 1-1', 'Essa é a exposição 1-1', 'ecomuseu1', 'expo1sala1','1');
INSERT INTO Exposition (id, name, description, coverImageSrc, qrCodeLink, idRoomLanguage) VALUES (2, 'Exposição 2-1', 'Essa é a exposição 2-1', 'ecomuseu2', 'expo2sala1','1');
INSERT INTO Exposition (id, name, description, coverImageSrc, qrCodeLink, idRoomLanguage) VALUES (3, 'Exposição 3-1', 'Essa é a exposição 3-1', 'ecomuseu3', 'expo3sala1','1');
INSERT INTO Exposition (id, name, description, coverImageSrc, qrCodeLink, idRoomLanguage) VALUES (4, 'Exposição 4-1', 'Essa é a exposição 4-1', 'ecomuseu4', 'expo4sala1','1');
INSERT INTO Exposition (id, name, description, coverImageSrc, qrCodeLink, idRoomLanguage) VALUES (5, 'Exposição 5-1', 'Essa é a exposição 5-1', 'ecomuseu5', 'expo5sala1','1');

INSERT INTO Exposition (id, name, description, coverImageSrc, qrCodeLink, idRoomLanguage) VALUES (6, 'Exposição 1-2', 'Essa é a exposição 1-2', 'ecomuseu1', 'expo1sala2','2');
INSERT INTO Exposition (id, name, description, coverImageSrc, qrCodeLink, idRoomLanguage) VALUES (7, 'Exposição 2-2', 'Essa é a exposição 2-2', 'ecomuseu2', 'expo2sala2','2');

INSERT INTO Exposition (id, name, description, coverImageSrc, qrCodeLink, idRoomLanguage) VALUES (8, 'Exposição 1-3', 'Essa é a exposição 1-3', 'ecomuseu3', 'expo1sala3','3');

INSERT INTO Exposition (id, name, description, coverImageSrc, qrCodeLink, idRoomLanguage) VALUES (9, 'Exposition 1-1', 'This is exposition 1-1', 'ecomuseu1', 'expo1sala1','5');
INSERT INTO Exposition (id, name, description, coverImageSrc, qrCodeLink, idRoomLanguage) VALUES (10, 'Exposition 2-1', 'This is exposition 2-1', 'ecomuseu2', 'expo2sala1','5');
INSERT INTO Exposition (id, name, description, coverImageSrc, qrCodeLink, idRoomLanguage) VALUES (11, 'Exposition 3-1', 'This is exposition 3-1', 'ecomuseu3', 'expo3sala1','5');
INSERT INTO Exposition (id, name, description, coverImageSrc, qrCodeLink, idRoomLanguage) VALUES (12, 'Exposition 4-1', 'This is exposition 4-1', 'ecomuseu4', 'expo4sala1','5');
INSERT INTO Exposition (id, name, description, coverImageSrc, qrCodeLink, idRoomLanguage) VALUES (13, 'Exposition 5-1', 'This is exposition 5-1', 'ecomuseu5', 'expo5sala1','5');

INSERT INTO Exposition (id, name, description, coverImageSrc, qrCodeLink, idRoomLanguage) VALUES (14, 'Exposition 1-2', 'This is exposition 1-2', 'ecomuseu1', 'expo1sala2','6');
INSERT INTO Exposition (id, name, description, coverImageSrc, qrCodeLink, idRoomLanguage) VALUES (15, 'Exposition 2-2', 'This is exposition 2-2', 'ecomuseu2', 'expo2sala2','6');

INSERT INTO Exposition (id, name, description, coverImageSrc, qrCodeLink, idRoomLanguage) VALUES (16, 'Exposition 1-3', 'This is exposition 1-3', 'ecomuseu3', 'expo1sala3','7');


INSERT INTO Panel (id, idExposition) VALUES (1,1);
INSERT INTO Panel (id, idExposition) VALUES (2,2);
INSERT INTO Panel (id, idExposition) VALUES (3,3);
INSERT INTO Panel (id, idExposition) VALUES (4,4);
INSERT INTO Panel (id, idExposition) VALUES (5,5);
INSERT INTO Panel (id, idExposition) VALUES (6,6);
INSERT INTO Panel (id, idExposition) VALUES (7,7);
INSERT INTO Panel (id, idExposition) VALUES (8,8);

INSERT INTO Panel (id, idExposition) VALUES (9,9);
INSERT INTO Panel (id, idExposition) VALUES (10,10);
INSERT INTO Panel (id, idExposition) VALUES (11,11);
INSERT INTO Panel (id, idExposition) VALUES (12,12);
INSERT INTO Panel (id, idExposition) VALUES (13,13);
INSERT INTO Panel (id, idExposition) VALUES (14,14);
INSERT INTO Panel (id, idExposition) VALUES (15,15);
INSERT INTO Panel (id, idExposition) VALUES (16,16);

INSERT INTO Audio (id, source, idPanel) VALUES (1, 'audio1', 1);
INSERT INTO Audio (id, source, idPanel) VALUES (2, 'audio2', 2);
INSERT INTO Audio (id, source, idPanel) VALUES (3, 'audio3', 3);
INSERT INTO Audio (id, source, idPanel) VALUES (4, 'audio4', 4);
INSERT INTO Audio (id, source, idPanel) VALUES (5, 'audio5', 5);
INSERT INTO Audio (id, source, idPanel) VALUES (6, 'audio6', 6);
INSERT INTO Audio (id, source, idPanel) VALUES (7, 'audio7', 7);
INSERT INTO Audio (id, source, idPanel) VALUES (8, 'audio8', 8);
INSERT INTO Audio (id, source, idPanel) VALUES (9, 'audio9', 9);
INSERT INTO Audio (id, source, idPanel) VALUES (10, 'audio10', 10);
INSERT INTO Audio (id, source, idPanel) VALUES (11, 'audio11', 11);
INSERT INTO Audio (id, source, idPanel) VALUES (12, 'audio12', 12);
INSERT INTO Audio (id, source, idPanel) VALUES (13, 'audio13', 13);
INSERT INTO Audio (id, source, idPanel) VALUES (14, 'audio14', 14);
INSERT INTO Audio (id, source, idPanel) VALUES (15, 'audio15', 15);
INSERT INTO Audio (id, source, idPanel) VALUES (16, 'audio16', 16);

INSERT INTO Images (id, source) VALUES (1, 'image1');
INSERT INTO Images (id, source) VALUES (2, 'image2');
INSERT INTO Images (id, source) VALUES (3, 'image3');
INSERT INTO Images (id, source) VALUES (4, 'image4');
INSERT INTO Images (id, source) VALUES (5, 'image1');
INSERT INTO Images (id, source) VALUES (6, 'image2');
INSERT INTO Images (id, source) VALUES (7, 'image3');
INSERT INTO Images (id, source) VALUES (8, 'image3');
INSERT INTO Images (id, source) VALUES (9, 'image4');
INSERT INTO Images (id, source) VALUES (10, 'image1');
INSERT INTO Images (id, source) VALUES (11, 'image2');
INSERT INTO Images (id, source) VALUES (12, 'image3');
INSERT INTO Images (id, source) VALUES (13, 'image4');
INSERT INTO Images (id, source) VALUES (14, 'image1');
INSERT INTO Images (id, source) VALUES (15, 'image2');
INSERT INTO Images (id, source) VALUES (16, 'image3');
INSERT INTO Images (id, source) VALUES (17, 'image1');
INSERT INTO Images (id, source) VALUES (18, 'image2');
INSERT INTO Images (id, source) VALUES (19, 'image3');
INSERT INTO Images (id, source) VALUES (20, 'image2');
INSERT INTO Images (id, source) VALUES (21, 'image3');
INSERT INTO Images (id, source) VALUES (22, 'image4');
INSERT INTO Images (id, source) VALUES (23, 'image3');
INSERT INTO Images (id, source) VALUES (24, 'image3');
INSERT INTO Images (id, source) VALUES (25, 'image4');
INSERT INTO Images (id, source) VALUES (26, 'image1');
INSERT INTO Images (id, source) VALUES (27, 'image2');
INSERT INTO Images (id, source) VALUES (28, 'image3');

INSERT INTO PanelImages(idPanel, idImage) VALUES (1,1);
INSERT INTO PanelImages(idPanel, idImage) VALUES (1,2);
INSERT INTO PanelImages(idPanel, idImage) VALUES (1,3);
INSERT INTO PanelImages(idPanel, idImage) VALUES (1,4);
INSERT INTO PanelImages(idPanel, idImage) VALUES (2,5);
INSERT INTO PanelImages(idPanel, idImage) VALUES (2,6);
INSERT INTO PanelImages(idPanel, idImage) VALUES (2,7);
INSERT INTO PanelImages(idPanel, idImage) VALUES (3,8);
INSERT INTO PanelImages(idPanel, idImage) VALUES (3,9);
INSERT INTO PanelImages(idPanel, idImage) VALUES (3,10);
INSERT INTO PanelImages(idPanel, idImage) VALUES (4,11);
INSERT INTO PanelImages(idPanel, idImage) VALUES (4,12);
INSERT INTO PanelImages(idPanel, idImage) VALUES (4,13);
INSERT INTO PanelImages(idPanel, idImage) VALUES (4,14);
INSERT INTO PanelImages(idPanel, idImage) VALUES (4,15);
INSERT INTO PanelImages(idPanel, idImage) VALUES (4,16);
INSERT INTO PanelImages(idPanel, idImage) VALUES (5,17);
INSERT INTO PanelImages(idPanel, idImage) VALUES (5,18);
INSERT INTO PanelImages(idPanel, idImage) VALUES (5,19);
INSERT INTO PanelImages(idPanel, idImage) VALUES (6,20);
INSERT INTO PanelImages(idPanel, idImage) VALUES (7,21);
INSERT INTO PanelImages(idPanel, idImage) VALUES (7,22);
INSERT INTO PanelImages(idPanel, idImage) VALUES (8,23);
INSERT INTO PanelImages(idPanel, idImage) VALUES (8,24);
INSERT INTO PanelImages(idPanel, idImage) VALUES (8,25);
INSERT INTO PanelImages(idPanel, idImage) VALUES (8,26);
INSERT INTO PanelImages(idPanel, idImage) VALUES (8,27);
INSERT INTO PanelImages(idPanel, idImage) VALUES (8,28);

INSERT INTO PanelImages(idPanel, idImage) VALUES (9,1);
INSERT INTO PanelImages(idPanel, idImage) VALUES (9,2);
INSERT INTO PanelImages(idPanel, idImage) VALUES (9,3);
INSERT INTO PanelImages(idPanel, idImage) VALUES (9,4);
INSERT INTO PanelImages(idPanel, idImage) VALUES (10,5);
INSERT INTO PanelImages(idPanel, idImage) VALUES (10,6);
INSERT INTO PanelImages(idPanel, idImage) VALUES (10,7);
INSERT INTO PanelImages(idPanel, idImage) VALUES (11,8);
INSERT INTO PanelImages(idPanel, idImage) VALUES (11,9);
INSERT INTO PanelImages(idPanel, idImage) VALUES (11,10);
INSERT INTO PanelImages(idPanel, idImage) VALUES (12,11);
INSERT INTO PanelImages(idPanel, idImage) VALUES (12,12);
INSERT INTO PanelImages(idPanel, idImage) VALUES (12,13);
INSERT INTO PanelImages(idPanel, idImage) VALUES (12,14);
INSERT INTO PanelImages(idPanel, idImage) VALUES (12,15);
INSERT INTO PanelImages(idPanel, idImage) VALUES (12,16);
INSERT INTO PanelImages(idPanel, idImage) VALUES (13,17);
INSERT INTO PanelImages(idPanel, idImage) VALUES (13,18);
INSERT INTO PanelImages(idPanel, idImage) VALUES (13,19);
INSERT INTO PanelImages(idPanel, idImage) VALUES (14,20);
INSERT INTO PanelImages(idPanel, idImage) VALUES (15,21);
INSERT INTO PanelImages(idPanel, idImage) VALUES (15,22);
INSERT INTO PanelImages(idPanel, idImage) VALUES (16,23);
INSERT INTO PanelImages(idPanel, idImage) VALUES (16,24);
INSERT INTO PanelImages(idPanel, idImage) VALUES (16,25);
INSERT INTO PanelImages(idPanel, idImage) VALUES (16,26);
INSERT INTO PanelImages(idPanel, idImage) VALUES (16,27);
INSERT INTO PanelImages(idPanel, idImage) VALUES (16,28);

INSERT INTO Text (id, text) VALUES (1, "Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1");
INSERT INTO Text (id, text) VALUES (2, "Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2");
INSERT INTO Text (id, text) VALUES (3, "Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3");
INSERT INTO Text (id, text) VALUES (4, "Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4");
INSERT INTO Text (id, text) VALUES (5, "Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5");
INSERT INTO Text (id, text) VALUES (6, "Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6");

INSERT INTO Text (id, text) VALUES (7, "Test 1 Test 1 Test 1 Test 1 Test 1 Test 1 Test 1 Test 1 Test 1 Test 1 Test 1 Test 1 Test 1 Test 1 Test 1 Test 1 Test 1 Test 1 Test 1 Test 1 Test 1 Test 1 Test 1 Test 1 Test 1 Test 1 Test 1 Test 1 Test 1 Test 1 Test 1 Test 1 Test 1 Test 1 Test 1 Test 1 Test 1 Test 1 Test 1 Test 1 Test 1 Test 1 Test 1 Test 1");
INSERT INTO Text (id, text) VALUES (8, "Test 2 Test 2 Test 2 Test 2 Test 2 Test 2 Test 2 Test 2 Test 2 Test 2 Test 2 Test 2 Test 2 Test 2 Test 2 Test 2 Test 2 Test 2 Test 2 Test 2 Test 2 Test 2 Test 2 Test 2 Test 2 Test 2 Test 2 Test 2 Test 2 Test 2 Test 2 Test 2 Test 2 Test 2 Test 2 Test 2 Test 2 Test 2 Test 2 Test 2 Test 2 Test 2 Test 2 Test 2 Test 2 Test 2");
INSERT INTO Text (id, text) VALUES (9, "Test 3 Test 3 Test 3 Test 3 Test 3 Test 3 Test 3 Test 3 Test 3 Test 3 Test 3 Test 3 Test 3 Test 3 Test 3 Test 3 Test 3 Test 3 Test 3 Test 3 Test 3 Test 3 Test 3 Test 3 Test 3 Test 3 Test 3 Test 3 Test 3 Test 3 Test 3 Test 3 Test 3 Test 3");
INSERT INTO Text (id, text) VALUES (10, "Test 4 Test 4 Test 4 Test 4 Test 4 Test 4 Test 4 Test 4 Test 4 Test 4 Test 4 Test 4 Test 4 Test 4 Test 4 Test 4 Test 4 Test 4 Test 4 Test 4 Test 4 Test 4 Test 4 Test 4 Test 4 Test 4 Test 4 Test 4 Test 4 Test 4 Test 4 Test 4 Test 4 Test 4 Test 4 Test 4 Test 4 Test 4 Test 4 Test 4 Test 4 Test 4");
INSERT INTO Text (id, text) VALUES (11, "Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5 Test 5");
INSERT INTO Text (id, text) VALUES (12, "Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6 Test 6");


INSERT INTO Paragraph (idText, idPanel) VALUES (1,1);
INSERT INTO Paragraph (idText, idPanel) VALUES (2,1);
INSERT INTO Paragraph (idText, idPanel) VALUES (3,1);
INSERT INTO Paragraph (idText, idPanel) VALUES (4,2);
INSERT INTO Paragraph (idText, idPanel) VALUES (5,2);
INSERT INTO Paragraph (idText, idPanel) VALUES (6,2);
INSERT INTO Paragraph (idText, idPanel) VALUES (1,3);
INSERT INTO Paragraph (idText, idPanel) VALUES (3,3);
INSERT INTO Paragraph (idText, idPanel) VALUES (6,3);
INSERT INTO Paragraph (idText, idPanel) VALUES (2,4);
INSERT INTO Paragraph (idText, idPanel) VALUES (4,4);
INSERT INTO Paragraph (idText, idPanel) VALUES (6,4);
INSERT INTO Paragraph (idText, idPanel) VALUES (1,5);
INSERT INTO Paragraph (idText, idPanel) VALUES (2,5);
INSERT INTO Paragraph (idText, idPanel) VALUES (5,5);
INSERT INTO Paragraph (idText, idPanel) VALUES (6,5);
INSERT INTO Paragraph (idText, idPanel) VALUES (3,6);
INSERT INTO Paragraph (idText, idPanel) VALUES (4,6);
INSERT INTO Paragraph (idText, idPanel) VALUES (1,7);
INSERT INTO Paragraph (idText, idPanel) VALUES (6,7);
INSERT INTO Paragraph (idText, idPanel) VALUES (2,8);
INSERT INTO Paragraph (idText, idPanel) VALUES (4,8);
INSERT INTO Paragraph (idText, idPanel) VALUES (5,8);

INSERT INTO Paragraph (idText, idPanel) VALUES (7,9);
INSERT INTO Paragraph (idText, idPanel) VALUES (8,9);
INSERT INTO Paragraph (idText, idPanel) VALUES (9,9);
INSERT INTO Paragraph (idText, idPanel) VALUES (10,10);
INSERT INTO Paragraph (idText, idPanel) VALUES (11,10);
INSERT INTO Paragraph (idText, idPanel) VALUES (12,10);
INSERT INTO Paragraph (idText, idPanel) VALUES (7,11);
INSERT INTO Paragraph (idText, idPanel) VALUES (9,11);
INSERT INTO Paragraph (idText, idPanel) VALUES (12,11);
INSERT INTO Paragraph (idText, idPanel) VALUES (8,12);
INSERT INTO Paragraph (idText, idPanel) VALUES (10,12);
INSERT INTO Paragraph (idText, idPanel) VALUES (12,12);
INSERT INTO Paragraph (idText, idPanel) VALUES (7,13);
INSERT INTO Paragraph (idText, idPanel) VALUES (8,13);
INSERT INTO Paragraph (idText, idPanel) VALUES (11,13);
INSERT INTO Paragraph (idText, idPanel) VALUES (12,13);
INSERT INTO Paragraph (idText, idPanel) VALUES (9,14);
INSERT INTO Paragraph (idText, idPanel) VALUES (10,14);
INSERT INTO Paragraph (idText, idPanel) VALUES (7,15);
INSERT INTO Paragraph (idText, idPanel) VALUES (12,15);
INSERT INTO Paragraph (idText, idPanel) VALUES (8,16);
INSERT INTO Paragraph (idText, idPanel) VALUES (10,16);
INSERT INTO Paragraph (idText, idPanel) VALUES (11,16);

