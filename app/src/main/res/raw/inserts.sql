
/* Languages */
INSERT INTO Language (id, language, countryCode) VALUES (1,"pt","BR");
INSERT INTO Language (id, language, countryCode) VALUES (2,"en","US");

/* Base Rooms */
INSERT INTO Room (id, coverImageSrc, mapIdentification) VALUES (1, 'thumbnail/room_thumbnail_rodadagua', 'rodaDagua');
INSERT INTO Room (id, coverImageSrc, mapIdentification) VALUES (2, 'thumbnail/room_thumbnail_carrocaocarroboi', 'carrocaoCarroBoi');
INSERT INTO Room (id, coverImageSrc, mapIdentification) VALUES (3, 'thumbnail/room_thumbnail_exposicoes', 'exposicoesHall');
INSERT INTO Room (id, coverImageSrc, mapIdentification) VALUES (4, 'thumbnail/room_thumbnail_historiausina', 'historiaUsina');
INSERT INTO Room (id, coverImageSrc, mapIdentification) VALUES (5, 'thumbnail/room_thumbnail_prensafumo', 'prensaFumo');
INSERT INTO Room (id, coverImageSrc, mapIdentification) VALUES (6, 'thumbnail/room_thumbnail_moendamadeira', 'moendaMadeira');
INSERT INTO Room (id, coverImageSrc, mapIdentification) VALUES (7, 'thumbnail/room_thumbnail_enterramento', 'enterramento');
INSERT INTO Room (id, coverImageSrc, mapIdentification) VALUES (8, 'thumbnail/room_thumbnail_moendapedra', 'moendaPedra');
INSERT INTO Room (id, coverImageSrc, mapIdentification) VALUES (9, 'thumbnail/room_thumbnail_arrado', 'arrado');
INSERT INTO Room (id, coverImageSrc, mapIdentification) VALUES (10, 'thumbnail/room_thumbnail_caminhao', 'caminhao');
INSERT INTO Room (id, coverImageSrc, mapIdentification) VALUES (11, 'thumbnail/room_thumbnail_evolucao', 'evolucao');
INSERT INTO Room (id, coverImageSrc, mapIdentification) VALUES (12, 'thumbnail/room_thumbnail_espacoartes', 'espacoArtes');
INSERT INTO Room (id, coverImageSrc, mapIdentification) VALUES (13, 'thumbnail/room_thumbnail_turbina', 'turbina');
INSERT INTO Room (id, coverImageSrc, mapIdentification) VALUES (14, 'thumbnail/room_thumbnail_maqueterelevoregiao', 'maqueteRelevoRegiao');
INSERT INTO Room (id, coverImageSrc, mapIdentification) VALUES (15, 'thumbnail/room_thumbnail_maiormaquetemundo', 'maiorMaqueteMundo');
INSERT INTO Room (id, coverImageSrc, mapIdentification) VALUES (16, 'thumbnail/room_thumbnail_exposicaotemporaria', 'exposicaoTemporaria');
INSERT INTO Room (id, coverImageSrc, mapIdentification) VALUES (17, 'thumbnail/room_thumbnail_colecoes', 'colecoes');

/* Non Clickable Rooms - Português */
INSERT INTO NonClickableRoom (id, mapIdentification, name, idLanguage) VALUES (1, 'flecha', 'Entrada por aqui', 1);
INSERT INTO NonClickableRoom (id, mapIdentification, name, idLanguage) VALUES (2, 'copa', 'Copa', 1);
INSERT INTO NonClickableRoom (id, mapIdentification, name, idLanguage) VALUES (3, 'entrada', 'Entrada', 1);
INSERT INTO NonClickableRoom (id, mapIdentification, name, idLanguage) VALUES (4, 'auditorio', 'Auditório', 1);
INSERT INTO NonClickableRoom (id, mapIdentification, name, idLanguage) VALUES (5, 'banheiro1', 'Banheiro', 1);
INSERT INTO NonClickableRoom (id, mapIdentification, name, idLanguage) VALUES (6, 'banheiro2', 'Banheiro', 1);
INSERT INTO NonClickableRoom (id, mapIdentification, name, idLanguage) VALUES (7, 'manuntencao', 'Manuntenção', 1);
INSERT INTO NonClickableRoom (id, mapIdentification, name, idLanguage) VALUES (8, 'banheiro3', 'Banheiro', 1);
INSERT INTO NonClickableRoom (id, mapIdentification, name, idLanguage) VALUES (9, 'banheiro4', 'Banheiro', 1);
INSERT INTO NonClickableRoom (id, mapIdentification, name, idLanguage) VALUES (10, 'biblioteca', 'Biblioteca', 1);
INSERT INTO NonClickableRoom (id, mapIdentification, name, idLanguage) VALUES (11, 'acervo', 'Acervo', 1);
INSERT INTO NonClickableRoom (id, mapIdentification, name, idLanguage) VALUES (12, 'espacoRecreativo', 'Espaço Recreativo', 1);
INSERT INTO NonClickableRoom (id, mapIdentification, name, idLanguage) VALUES (13, 'atividadeEducativa1','Atividade Educacional 1',1);
INSERT INTO NonClickableRoom (id, mapIdentification, name, idLanguage) VALUES (14, 'atividadeEducativa2','Atividade Educacional 2',1);

/* Non Clickable Rooms - Inglês */
INSERT INTO NonClickableRoom (id, mapIdentification, name, idLanguage) VALUES (15, 'flecha', 'Entrance over here', 2);
INSERT INTO NonClickableRoom (id, mapIdentification, name, idLanguage) VALUES (16, 'copa', 'Pantry', 2);
INSERT INTO NonClickableRoom (id, mapIdentification, name, idLanguage) VALUES (17, 'entrar', 'Entrance', 2);
INSERT INTO NonClickableRoom (id, mapIdentification, name, idLanguage) VALUES (18, 'auditorio', 'Auditorium', 2);
INSERT INTO NonClickableRoom (id, mapIdentification, name, idLanguage) VALUES (19, 'banheiro1', 'Bathroom', 2);
INSERT INTO NonClickableRoom (id, mapIdentification, name, idLanguage) VALUES (20, 'banheiro2', 'Bathroom', 2);
INSERT INTO NonClickableRoom (id, mapIdentification, name, idLanguage) VALUES (21, 'manuntencao', 'Maintenance', 2);
INSERT INTO NonClickableRoom (id, mapIdentification, name, idLanguage) VALUES (22, 'banheiro3', 'Bathroom', 2);
INSERT INTO NonClickableRoom (id, mapIdentification, name, idLanguage) VALUES (23, 'banheiro4', 'Bathroom', 2);
INSERT INTO NonClickableRoom (id, mapIdentification, name, idLanguage) VALUES (24, 'biblioteca', 'Library', 2);
INSERT INTO NonClickableRoom (id, mapIdentification, name, idLanguage) VALUES (25, 'acervo', 'Archives', 2);
INSERT INTO NonClickableRoom (id, mapIdentification, name, idLanguage) VALUES (26, 'espacoRecreativo', 'Recreational Space', 2);
INSERT INTO NonClickableRoom (id, mapIdentification, name, idLanguage) VALUES (27, 'atividadeEducativa1','Educational Activity 1',2);
INSERT INTO NonClickableRoom (id, mapIdentification, name, idLanguage) VALUES (28, 'atividadeEducativa2','Educational Activity 2',2);

/* Achievements */
INSERT INTO Achievement (id, points, idRoom) VALUES (1, 60, 1);
INSERT INTO Achievement (id, points, idRoom) VALUES (2, 60, 2);
INSERT INTO Achievement (id, points, idRoom) VALUES (3, 150, 3);
INSERT INTO Achievement (id, points, idRoom) VALUES (4, 130, 4);
INSERT INTO Achievement (id, points, idRoom) VALUES (5, 75, 5);
INSERT INTO Achievement (id, points, idRoom) VALUES (6, 75, 6);
INSERT INTO Achievement (id, points, idRoom) VALUES (7, 75, 7);
INSERT INTO Achievement (id, points, idRoom) VALUES (8, 75, 8);
INSERT INTO Achievement (id, points, idRoom) VALUES (9, 75, 9);
INSERT INTO Achievement (id, points, idRoom) VALUES (10, 90, 10);
INSERT INTO Achievement (id, points, idRoom) VALUES (11, 110, 11);
INSERT INTO Achievement (id, points, idRoom) VALUES (12, 100, 12);
INSERT INTO Achievement (id, points, idRoom) VALUES (13, 150, 13);
INSERT INTO Achievement (id, points, idRoom) VALUES (14, 100, 14);
INSERT INTO Achievement (id, points, idRoom) VALUES (15, 150, 15);
INSERT INTO Achievement (id, points, idRoom) VALUES (16, 100, 16);
INSERT INTO Achievement (id, points, idRoom) VALUES (17, 120, 17);

/* Rooms - Português */
INSERT INTO RoomLanguage (id, idRoom, idLanguage, name, description) VALUES (1,1,1, "Roda D Água", "Dispositivo gerador de energia hidráulica.");
INSERT INTO RoomLanguage (id, idRoom, idLanguage, name, description) VALUES (2,2,1, 'Carroças', 'Veículos antigos para transporte de cargas.');
INSERT INTO RoomLanguage (id, idRoom, idLanguage, name, description) VALUES (3,3,1, 'Hall de Exposições', 'Exposições diversas de Foz do Iguaçu e região');
INSERT INTO RoomLanguage (id, idRoom, idLanguage, name, description) VALUES (4,4,1, 'História da Usina Hidrelétrica', 'Uma breve história da Itaipu');
INSERT INTO RoomLanguage (id, idRoom, idLanguage, name, description) VALUES (5,5,1, "Prensa de Fumo", "Ferramenta antiga para enfardar folhas de fumo");
INSERT INTO RoomLanguage (id, idRoom, idLanguage, name, description) VALUES (6,6,1, 'Moenda de Madeira', 'Moenda com cilindros de madeira para extração de derivados da cana.');
INSERT INTO RoomLanguage (id, idRoom, idLanguage, name, description) VALUES (7,7,1, 'Enterramento', 'Sepultamento de corpos ou ossos em urnas');
INSERT INTO RoomLanguage (id, idRoom, idLanguage, name, description) VALUES (8,8,1, 'Moenda de Pedra', 'Moenda com cilindros de pedra para extração de derivados da cana');
INSERT INTO RoomLanguage (id, idRoom, idLanguage, name, description) VALUES (9,9,1, "Arrado", "Ferramenta antiga para facilitar o preparo da terra.");
INSERT INTO RoomLanguage (id, idRoom, idLanguage, name, description) VALUES (10,10,1, 'Caminhão Sansão', 'Caminhão utilizado na construção da Itaipu.');
INSERT INTO RoomLanguage (id, idRoom, idLanguage, name, description) VALUES (11,11,1, 'Espaço da Evolução', 'Evolução de ferramentas e sociedade');
INSERT INTO RoomLanguage (id, idRoom, idLanguage, name, description) VALUES (12,12,1, 'Espaço das Artes', 'Obras de arte feitas com material sustentável');
INSERT INTO RoomLanguage (id, idRoom, idLanguage, name, description) VALUES (13,13,1, "Sala da Turbina", "Simulação de uma turbina da Itaipu");
INSERT INTO RoomLanguage (id, idRoom, idLanguage, name, description) VALUES (14,14,1, 'Maquete do Relevo da Região', 'Maquete mostrando a região.');
INSERT INTO RoomLanguage (id, idRoom, idLanguage, name, description) VALUES (15,15,1, 'Maior Maquete do Mundo', 'Maior maquete do mundo mostrando toda a area da usina');
INSERT INTO RoomLanguage (id, idRoom, idLanguage, name, description) VALUES (16,16,1, 'Exposição Temporária', 'Exposições que mudam de tempos em tempos.');
INSERT INTO RoomLanguage (id, idRoom, idLanguage, name, description) VALUES (17,17,1, 'Coleções', 'Várias coleções de diversos artefatos');

/* Rooms - Inglês */
INSERT INTO RoomLanguage (id, idRoom, idLanguage, name, description) VALUES (20,1,2, "Water Wheel", "Hidraulic power generator.");
INSERT INTO RoomLanguage (id, idRoom, idLanguage, name, description) VALUES (21,2,2, 'Wagons', 'Old vehicles for cargo transportation.');
INSERT INTO RoomLanguage (id, idRoom, idLanguage, name, description) VALUES (22,3,2, 'Expositions Hall', 'Several expositions about Foz do Iguassu and region.');
INSERT INTO RoomLanguage (id, idRoom, idLanguage, name, description) VALUES (23,4,2, 'History of Hydroelectric Plant', 'A brief history about Itaipu.');
INSERT INTO RoomLanguage (id, idRoom, idLanguage, name, description) VALUES (24,5,2, "Tobacco Press", "Old tool for bailing tobacco leaves.");
INSERT INTO RoomLanguage (id, idRoom, idLanguage, name, description) VALUES (25,6,2, 'Milling with Wood Rollers', 'Milling with wood rollers for the extraction of cane derivatives.');
INSERT INTO RoomLanguage (id, idRoom, idLanguage, name, description) VALUES (26,7,2, 'Burial', 'Sepultamento de corpos ou ossos em urnas.');
INSERT INTO RoomLanguage (id, idRoom, idLanguage, name, description) VALUES (27,8,2, 'Milling with Stone Rollers', 'Milling with stone rollers for the extraction of cane derivatives.');
INSERT INTO RoomLanguage (id, idRoom, idLanguage, name, description) VALUES (28,9,2, "Ploughs", "Old tool to facilitate land preparation.");
INSERT INTO RoomLanguage (id, idRoom, idLanguage, name, description) VALUES (29,10,2, 'Sansão Truck', 'Truck used in Itaipu building.');
INSERT INTO RoomLanguage (id, idRoom, idLanguage, name, description) VALUES (30,11,2, 'Evolution Space', 'Evolution of tools and society.');
INSERT INTO RoomLanguage (id, idRoom, idLanguage, name, description) VALUES (31,12,2, 'Art Space', 'Artwork with sustainable materials.');
INSERT INTO RoomLanguage (id, idRoom, idLanguage, name, description) VALUES (32,13,2, "Turbine Room", "Itaipu turbine simulation");
INSERT INTO RoomLanguage (id, idRoom, idLanguage, name, description) VALUES (33,14,2, 'Model of the Region', 'Model of the topography of the region.');
INSERT INTO RoomLanguage (id, idRoom, idLanguage, name, description) VALUES (34,15,2, 'Biggets Maquette of World', 'Biggets maquette of world showing the whole area of Itaipu.');
INSERT INTO RoomLanguage (id, idRoom, idLanguage, name, description) VALUES (35,16,2, 'Temporary Exposition', 'Exhibitions that change from time to time.');
INSERT INTO RoomLanguage (id, idRoom, idLanguage, name, description) VALUES (36,17,2, 'Collections', 'Several collections of various artifacts.');

/* Images */
INSERT INTO Images (id, source) VALUES (1, 'photos/exposition_image_rodadagua');
INSERT INTO Images (id, source) VALUES (2, 'photos/exposition_image_carrocao');
INSERT INTO Images (id, source) VALUES (3, 'photos/exposition_image_carroboi');


/* Expositions - Room 1 - Roda D Agua*/
/* Portugues */
INSERT INTO Exposition (id, name, description, coverImageSrc, qrCodeLink, idRoomLanguage) VALUES (1, 'Roda D Agua de Madeira', 'Dispositivo gerador de energia hidráulica', 'thumbnail/exposition_thumbnail_rodadagua', 'rodadagua_expoRodadagua',1);
INSERT INTO Panel (id, idExposition) VALUES (1,1);
INSERT INTO Audio (id, source, idPanel) VALUES (1, 'exposition_audio_rodadagua_pt_br', 1);
INSERT INTO PanelImages(idPanel, idImage) VALUES (1,1);
INSERT INTO Text (id, text) VALUES (1, "A roda d’agua esteve presente em praticamente todo o oeste do Paraná. Ainda hoje alguns exemplares podem ser encontrados em algumas propriedades rurais espalhadas pela região.");
INSERT INTO Text (id, text) VALUES (2, "Numa época em que não havia o fornecimento de energia elétrica, a roda d’agua cumpriu um papel imprescindível na vida econômica regional, acionando serrarias e moinhos coloniais.");
INSERT INTO Paragraph (idText, idPanel) VALUES (1,1);
INSERT INTO Paragraph (idText, idPanel) VALUES (2,1);
/* Inglês */
INSERT INTO Exposition (id, name, description, coverImageSrc, qrCodeLink, idRoomLanguage) VALUES (2, 'Wood Water Wheel', 'Hidraulic power generator', 'thumbnail/exposition_thumbnail_rodadagua', 'rodadagua_expoRodadagua',20);
INSERT INTO Panel (id, idExposition) VALUES (2,2);
INSERT INTO Audio (id, source, idPanel) VALUES (2, 'exposition_audio_rodadagua_en_us', 2);
INSERT INTO PanelImages(idPanel, idImage) VALUES (2,1);
INSERT INTO Text (id, text) VALUES (3, "Water wheels could be found practically all over the west of Paraná. Some of them may still be found in a few rural properties scattered through the region.");
INSERT INTO Text (id, text) VALUES (4, "At a time when there was no electric power supply, water wheels played a critical role in the region's economic life, by providing sawmills and grinding mills with power in the colonial period.");
INSERT INTO Paragraph (idText, idPanel) VALUES (3,2);
INSERT INTO Paragraph (idText, idPanel) VALUES (4,2);


/* Expositions - Room 2 - Carroças */
/* Carroção */
/* Portugues */
INSERT INTO Exposition (id, name, description, coverImageSrc, qrCodeLink, idRoomLanguage) VALUES (3, 'Carroção de Alçaprema', 'Para transporte de toras retiradas do meio da mata', 'thumbnail/exposition_thumbnail_carrocao', 'carrocaoCarroBoi_expoCarrocao',2);
INSERT INTO Panel (id, idExposition) VALUES (3,3);
INSERT INTO Audio (id, source, idPanel) VALUES (3, 'exposition_audio_carrocao_pt_br', 3);
INSERT INTO PanelImages(idPanel, idImage) VALUES (3,2);
INSERT INTO Text (id, text) VALUES (5, "A presença deste instrumento de trabalho no oeste paranaense, destinado basicamente ao transporte de toras retiradas do meio da mata fechada, remonta aos primordiais da colonização desta região, a partir das últimas décadas do século XIX.");
INSERT INTO Text (id, text) VALUES (6, "Era tracionado por uma junta de bois ou burros e o diâmetro das suas duas rodas, raiadas e protegidas por um aro de metal, chegava a ultrapassar os dois metros.");
INSERT INTO Paragraph (idText, idPanel) VALUES (5,3);
INSERT INTO Paragraph (idText, idPanel) VALUES (6,3);
/* Inglês */
INSERT INTO Exposition (id, name, description, coverImageSrc, qrCodeLink, idRoomLanguage) VALUES (4, 'Crowbar Wagon', 'For hauling logs out of the dense forest', 'thumbnail/exposition_thumbnail_carrocao', 'carrocaoCarroBoi_expoCarrocao',21);
INSERT INTO Panel (id, idExposition) VALUES (4,4);
INSERT INTO Audio (id, source, idPanel) VALUES (4, 'exposition_audio_carrocao_en_us', 4);
INSERT INTO PanelImages(idPanel, idImage) VALUES (4,2);
INSERT INTO Text (id, text) VALUES (7, "This tool was used in the west of Paraná basically for hauling logs out of the dense forest. It dates back to the region's early settlement days, at the end of the 19th Century.");
INSERT INTO Text (id, text) VALUES (8, "It was drawn by a pair of oxen or mules, and the diameter of its two spoked and metal-rim protected wheels, exceeded two meters.");
INSERT INTO Paragraph (idText, idPanel) VALUES (7,4);
INSERT INTO Paragraph (idText, idPanel) VALUES (8,4);
/* Carro de Boi */
/* Portugues */
INSERT INTO Exposition (id, name, description, coverImageSrc, qrCodeLink, idRoomLanguage) VALUES (5, 'Carro de Boi', 'Para transporte de toras retiradas do meio da mata', 'thumbnail/exposition_thumbnail_carroboi', 'carrocaoCarroBoi_expoCarroboi',2);
INSERT INTO Panel (id, idExposition) VALUES (5,5);
INSERT INTO Audio (id, source, idPanel) VALUES (5, 'exposition_audio_carroboi_pt_br', 5);
INSERT INTO PanelImages(idPanel, idImage) VALUES (5,3);
INSERT INTO Text (id, text) VALUES (9, "O carro de boi e uma das mais antigas invenções feitas pelo homem. Desempenhou, milenarmente, o papel de ser um dos mais usados meios de transportes terrestres.");
INSERT INTO Text (id, text) VALUES (10, "Na região oeste paranaense o carro de boi, com rodas inteiriças ou raiadas, foi utilizado desde do início do século XX para o transporte de erva-mate, cana-de-açúcar, fumo, madeira, grãos e outras variadas cargas.");
INSERT INTO Paragraph (idText, idPanel) VALUES (9,5);
INSERT INTO Paragraph (idText, idPanel) VALUES (10,5);
/* Inglês */
INSERT INTO Exposition (id, name, description, coverImageSrc, qrCodeLink, idRoomLanguage) VALUES (6, 'Ox Cart', 'Hidraulic power generator', 'thumbnail/exposition_thumbnail_carroboi', 'carrocaoCarroBoi_expoCarroboi',21);
INSERT INTO Panel (id, idExposition) VALUES (6,6);
INSERT INTO Audio (id, source, idPanel) VALUES (6, 'exposition_audio_carroboi_en_us', 6);
INSERT INTO PanelImages(idPanel, idImage) VALUES (6,3);
INSERT INTO Text (id, text) VALUES (11, "The ox cart is one of man's oldest inventions. For thousands of years, It has been one of the most widely used means of land transportation.");
INSERT INTO Text (id, text) VALUES (12, "In the west of Paraná, the ox cart, with solid or spoked wheels, has been used since the beginning of the 20th Century to transport mate leaves, sugar cane, tobacco, wood, grains, and other types of cargo.");
INSERT INTO Paragraph (idText, idPanel) VALUES (11,6);
INSERT INTO Paragraph (idText, idPanel) VALUES (12,6);