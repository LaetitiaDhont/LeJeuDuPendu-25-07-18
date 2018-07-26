package package1;
// Le jeu du pendu 
/*
 * Le but de ce jeu c´el`ebre est de deviner un mot dont les lettres sont initialement inconnues.
Le joueur doit proposer une lettre, et si celle-ci est dans le mot, alors toutes les occurrences
sont d´evoil´ees. La partie se termine une fois toutes les lettres du mot d´ecouvertes.
Voici un exemple de partie :
? ? ? ? ? ? ? ? ?
Lettre ? e
? ? ? ? ? e ? ? ?
Lettre ? u
? u ? u ? e ? ? u
Lettre ? a
? u ? u ? e ? ? u
Lettre ? l
? u l u ? e ? l u
Lettre ? r
? u l u ? e r l u
Lettre ? b
? u l u b e r l u
Lettre ? h
h u l u b e r l u
Felicitations, vous avez gagne !!
Pour la mod´elisation de ce jeu, un tableau de caract`eres sera utilis´e pour repr´esenter le
mot. Par exemple, le tableau [’d’,’e’,’v’,’i’,’n’,’e’] repr´esente le mot “devine”.
Pour g´erer les lettres qui sont connues, on aura aussi un tableau de bool´eens tel que la case
i contient true ssi la i-`eme lettre du mot a ´et´e d´ecouverte. Par exemple `a l’avant-derni`ere
´etape de l’exemple ci-dessus, on aura le tableau [true,true,false,true,true,true].
Le jeu s’arrˆete lorsque ce tableau ne contient que des true.
 */

// 1 . MOT VERS TAB
public class Game {
	// Première méthode 
	char [] motVersTab (String s) {
		int taille = s.length();
		char [] mot = new char [taille];
		
		// On veut récupérer chaque caractères de notre mot, pour cela
		// On utilise la méthode charAt qui nous permet de prendre chaque lettres d'un String
		int i;
		for (i =0; i<taille; i++) {
			mot[i] = s.charAt(i);		
		}
		return mot;
	}
	
// 2 . AFFICHAGE 
	// Deuxième méthode
	
	void affiche (char [] mot, boolean [] vu) {
		int i;
		for (i = 0; i<mot.length; i++) {
			// On veut afficher la valeur contenue dans l'indice du tableau
			if(vu[i] == true) {
				System.out.println(mot[i]);
			}
			else {
				System.out.println("?");
			}
		}	
	}
	
// 3 . MAJ du tableau de booléans 
	boolean [] metAjour (char [] mot, boolean [] vu, char ch) {
		int i;
		for (i = 0; i<mot.length; i++) {
			if (ch == mot[i]) {
				vu[i] = true;
			}
			
			else {
				vu[i] = false;
			}
			
		}
		return vu;
	}
}
