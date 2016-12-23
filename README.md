# Route34
Welcome to the Route34 wiki!

Route34 est une application Android qui permet les citoyens à signaler les abus infrastructurelle et les envoyer aux autorités.

L'application fonction avec REST architecture à'l'aide de library Voley qui permet communiquer avec le Backend (ecrit par PHP) avec le protocole HTTP.

L'application contient trois activités principale :

1- activité main : lancer l'appareil pour permet l'utilisateur de prendre une photo de l'anomalie , puis le rediriger vers une layout pour préciser la catégorie de l'anomalie, ici l'application prend les coordonnées(longitude & latitude) de l'utilisateur puis envoyer la réclamation au serveur web tout en utilisant library Voley (HTTPHandler).

2- activité Login : si l'utilisateur n'est s'authentifier il ne peut envoyer une réclamation, donc quand l'utilisateur a cliquer sur envoyer réclamation, il se redirige vers cette activité, et pour cette action on a entamer l'authentification par QRcode, donc il doit s'authentifier au site web tout d'abord et en se basant sur UUID le code php genere un QRcode puis l'utilisateur scan le code pour s'authentifier.

3- activité mesReclamtion : affiche tous les réclamation crée par l'utilisateur, qui peut les modifier ou supprimer.
