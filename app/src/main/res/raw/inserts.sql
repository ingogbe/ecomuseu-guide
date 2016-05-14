
INSERT INTO Language (id, language, countryCode) VALUES (1,"pt","BR");

INSERT INTO Room (id, name, description, coverImageSrc) VALUES (1, 'Sala 1', 'Essa é a sala 1', 'ecomuseu1');
INSERT INTO Room (id, name, description, coverImageSrc) VALUES (2, 'Sala 2', 'Essa é a sala 2', 'ecomuseu2');
INSERT INTO Room (id, name, description, coverImageSrc) VALUES (3, 'Sala 3', 'Essa é a sala 3', 'ecomuseu3');
INSERT INTO Room (id, name, description, coverImageSrc) VALUES (4, 'Sala 4', 'Essa é a sala 4', 'ecomuseu4');

INSERT INTO RoomLanguage (idRoom, idLanguage) VALUES (1,1);
INSERT INTO RoomLanguage (idRoom, idLanguage) VALUES (2,1);
INSERT INTO RoomLanguage (idRoom, idLanguage) VALUES (3,1);
INSERT INTO RoomLanguage (idRoom, idLanguage) VALUES (4,1);

INSERT INTO Exposition (id, name, description, coverImageSrc, qrCodeLink, idRoom) VALUES (1, 'Exposição 1-1', 'Essa é a exposição 1-1', 'ecomuseu1', 'expo1sala1','1');
INSERT INTO Exposition (id, name, description, coverImageSrc, qrCodeLink, idRoom) VALUES (2, 'Exposição 2-1', 'Essa é a exposição 2-1', 'ecomuseu2', 'expo2sala1','1');
INSERT INTO Exposition (id, name, description, coverImageSrc, qrCodeLink, idRoom) VALUES (3, 'Exposição 3-1', 'Essa é a exposição 3-1', 'ecomuseu3', 'expo3sala1','1');
INSERT INTO Exposition (id, name, description, coverImageSrc, qrCodeLink, idRoom) VALUES (4, 'Exposição 4-1', 'Essa é a exposição 4-1', 'ecomuseu4', 'expo4sala1','1');
INSERT INTO Exposition (id, name, description, coverImageSrc, qrCodeLink, idRoom) VALUES (5, 'Exposição 5-1', 'Essa é a exposição 5-1', 'ecomuseu5', 'expo5sala1','1');

INSERT INTO Exposition (id, name, description, coverImageSrc, qrCodeLink, idRoom) VALUES (6, 'Exposição 1-2', 'Essa é a exposição 1-2', 'ecomuseu1', 'expo1sala2','2');
INSERT INTO Exposition (id, name, description, coverImageSrc, qrCodeLink, idRoom) VALUES (7, 'Exposição 2-2', 'Essa é a exposição 2-2', 'ecomuseu2', 'expo2sala2','2');
INSERT INTO Exposition (id, name, description, coverImageSrc, qrCodeLink, idRoom) VALUES (8, 'Exposição 2-3', 'Essa é a exposição 3-2', 'ecomuseu3', 'expo3sala2','2');

INSERT INTO Panel (id, idExposition) VALUES (1,1);
INSERT INTO Panel (id, idExposition) VALUES (2,2);
INSERT INTO Panel (id, idExposition) VALUES (3,3);
INSERT INTO Panel (id, idExposition) VALUES (4,4);
INSERT INTO Panel (id, idExposition) VALUES (5,5);
INSERT INTO Panel (id, idExposition) VALUES (6,6);
INSERT INTO Panel (id, idExposition) VALUES (7,7);
INSERT INTO Panel (id, idExposition) VALUES (8,8);

INSERT INTO Audio (id, source, idPanel) VALUES (1, 'audio1', 1);
INSERT INTO Audio (id, source, idPanel) VALUES (2, 'audio2', 2);
INSERT INTO Audio (id, source, idPanel) VALUES (3, 'audio3', 3);
INSERT INTO Audio (id, source, idPanel) VALUES (4, 'audio4', 4);
INSERT INTO Audio (id, source, idPanel) VALUES (5, 'audio5', 5);
INSERT INTO Audio (id, source, idPanel) VALUES (6, 'audio5', 6);
INSERT INTO Audio (id, source, idPanel) VALUES (7, 'audio5', 7);
INSERT INTO Audio (id, source, idPanel) VALUES (8, 'audio5', 8);

INSERT INTO Images (id, source, idPanel) VALUES (1, 'image1', 1);
INSERT INTO Images (id, source, idPanel) VALUES (2, 'image2', 1);
INSERT INTO Images (id, source, idPanel) VALUES (3, 'image3', 1);
INSERT INTO Images (id, source, idPanel) VALUES (4, 'image4', 1);
INSERT INTO Images (id, source, idPanel) VALUES (5, 'image1', 2);
INSERT INTO Images (id, source, idPanel) VALUES (6, 'image2', 2);
INSERT INTO Images (id, source, idPanel) VALUES (7, 'image3', 2);
INSERT INTO Images (id, source, idPanel) VALUES (8, 'image3', 3);
INSERT INTO Images (id, source, idPanel) VALUES (9, 'image4', 3);
INSERT INTO Images (id, source, idPanel) VALUES (10, 'image1', 3);
INSERT INTO Images (id, source, idPanel) VALUES (11, 'image2', 4);
INSERT INTO Images (id, source, idPanel) VALUES (12, 'image3', 4);
INSERT INTO Images (id, source, idPanel) VALUES (13, 'image4', 4);
INSERT INTO Images (id, source, idPanel) VALUES (14, 'image1', 4);
INSERT INTO Images (id, source, idPanel) VALUES (15, 'image2', 4);
INSERT INTO Images (id, source, idPanel) VALUES (16, 'image3', 4);
INSERT INTO Images (id, source, idPanel) VALUES (17, 'image1', 5);
INSERT INTO Images (id, source, idPanel) VALUES (18, 'image2', 5);
INSERT INTO Images (id, source, idPanel) VALUES (19, 'image3', 5);
INSERT INTO Images (id, source, idPanel) VALUES (20, 'image2', 6);
INSERT INTO Images (id, source, idPanel) VALUES (21, 'image3', 7);
INSERT INTO Images (id, source, idPanel) VALUES (22, 'image4', 7);
INSERT INTO Images (id, source, idPanel) VALUES (23, 'image3', 8);
INSERT INTO Images (id, source, idPanel) VALUES (24, 'image3', 8);
INSERT INTO Images (id, source, idPanel) VALUES (25, 'image4', 8);
INSERT INTO Images (id, source, idPanel) VALUES (26, 'image1', 8);
INSERT INTO Images (id, source, idPanel) VALUES (27, 'image2', 8);
INSERT INTO Images (id, source, idPanel) VALUES (28, 'image3', 8);

INSERT INTO Text (id, text) VALUES (1, "Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1 Teste 1");
INSERT INTO Text (id, text) VALUES (2, "Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2 Teste 2");
INSERT INTO Text (id, text) VALUES (3, "Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3 Teste 3");
INSERT INTO Text (id, text) VALUES (4, "Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4 Teste 4");
INSERT INTO Text (id, text) VALUES (5, "Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5 Teste 5");
INSERT INTO Text (id, text) VALUES (6, "Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6 Teste 6");

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