
INSERT INTO `users` (`id`, `username`, `full_name`, `password_hash`) VALUES
	(1, 'bamba2001', 'Cheikh Ahmadou Bamba', 'd2de3a6d8360140858016a2ded29b754'),
	(2, 'cheikh', 'Cheikhouna Diop', '88c75c78bfd909aa3e85d341863b09b5'),
	(3, 'fall1999', 'Mbacke" fall', 'dea212cee54d411bae0bf792869c0468'),
	(4, 'Eckson', 'Eckson glitho', 'f521a51d6472c38b14b9c4d855f658be'),
	(5, 'Jenny', NULL, '56c28f25a1ba1cfddb6403d3dd546a8c'),
	(6, 'arfan', 'Arfan Gomis', '1b25433efef6396f6b9cd8f37a5959ce'),
	(7, 'fourya', 'Fourya Lô', '3de885842c7c72e54192a00b9d8e896c'),
	(8, 'adonsou', 'Robert Adonsou', '1e4213e13a52f81ea280132534e8957a'),
	(9, 'alou', 'Alassane sow', 'eb5e0c2e010b355dc2f916b14bd61403'),

INSERT INTO `posts` (`id`, `author_id`, `title`, `body`, `date`) VALUES
	(1, 2, 'SITE E-COMMERCE POUR PROJET SOLIDAIRE', 'Des scientifiques du Royaume-Uni et d’Ukraine ont développé une vodka unique en son genre en utilisant des céréales et des ingrédients de la zone d’exclusion issue de la catastrophe de Tchernobyl.', '2022-06-12 19:20:30'),
	(2, 7, 'WORDPRESS : LE CMS INCONTOURNABLE', 'WordPress est un système de gestion de contenu (CMS) né en 2003. Il est aujourd’hui devenu le leader incontesté du marché de la création de sites web : plus d’un site sur trois est actuellement développé avec le logiciel WordPress !Autrefois simple moteur de blog, il a su évoluer au fil des ans et s’affirmer en tant que solution crédible pour tout type de projet web : vitrine, corporate, dynamique, portail, catalogue, e-commerce…', '2022-06-10 22:30:00'),
	(3, 9, 'QUELLE MAINTENANCE POUR UN SITE WEB ?', 'La création d’un site Internet n’est pas une fin en soi… Pour rester performant, rapide et sécurisé, un site web a besoin d’une maintenance régulière.Mais en quoi consiste réellement cette maintenance ? Quels sont les enjeux de ce type de prestation ?', '2022-06-10 10:45:00'),