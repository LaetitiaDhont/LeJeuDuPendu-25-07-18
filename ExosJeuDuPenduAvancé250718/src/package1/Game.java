package package1;
// Le jeu du pendu 

public class Game {
	char [] motVersTab (String s) {
		int taille = s.length();
		char [] mot = new char [taille];
		
		// On veut r�cup�rer chaque caract�res de notre mot, pour cela
		// On utilise la m�thode charAt qui nous permet de prendre chaque lettres d'un String
		int i;
		for (i =0; i<taille; i++) {
			mot[i] = s.charAt(i);		
		}
		return mot;
	}
}
