INSERT INTO `blog` (`BLG_ID`, `DESCP`, `TITLE`) VALUES (1, 'Test Blog', 'First test blog');
INSERT INTO `article` (`ART_ID`, `ART_IMG`, `CONTENT`, `POST_DATE`, `TITLE`, `BLG_ID`) VALUES (1, 'd:\\images\\article_image\\0.png', 'Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. ', '2015-11-10', 'First Article', 1),(2, NULL, 'orem Ipsum has been the industry''s standard dummy text ever since the 1500s containing ', '2015-04-13', 'Second', 1),(3, 'd:\\images\\article_image\\0.png', 'It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing ', '2015-11-24', 'Third', 1),(4, NULL, 'It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing ', '2015-01-13', 'Fourth', 1),(5, NULL, 'It was popularised in the 1960s with the release of Letraset sheets containing ', '2015-10-09', 'Fifth', 1),(6, NULL, 'It was popularised in the 1960s with the release of Letraset sheets containing ', '2014-07-15', 'sixth', 1);
INSERT INTO `art_tag` (`Article_ART_ID`, `tags`) VALUES(1, 'first'),(2, 'second'),(3, 'third'),(4, 'first'),(5, 'second'),(6, 'first');