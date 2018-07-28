package package1;

import java.util.Scanner;

// Le jeu du pendu 
/*
 * Le but de ce jeu c�el`ebre est de deviner un mot dont les lettres sont initialement inconnues.
Le joueur doit proposer une lettre, et si celle-ci est dans le mot, alors toutes les occurrences
sont d�evoil�ees. La partie se termine une fois toutes les lettres du mot d�ecouvertes.
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
Felicitations, vous avez gagnez !!

 */





// 1 . MOT VERS TAB


public class Game {
	
	// Premi�re m�thode 
	
	private Scanner input;

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
	
// 2 . AFFICHAGE 
	// Deuxi�me m�thode
	
	void affiche (char [] mot, boolean [] vu) {
		
		// On parcourt chaque index i des tableaux pour atteindre la taille du tableau mot
		
		int i;
		for (i = 0; i<mot.length; i++) {
			// On veut afficher la valeur contenue dans l'indice du tableau
			// Si l'�l�ment de l'index i du tableau vu a pour valeur "true"
			
			if(vu[i] == true) {
				// On print l'�l�ment � l'index i du tab char mot 
				System.out.println(mot[i]);
			}
			
			else {
				// Sinon on affiche un point d'interrogation
				System.out.println("?");
				
			}
		}	
	}
	
	
// 3 . MAJ du tableau de bool�ans 
	
	boolean [] metAjour (char [] mot, boolean [] vu, char ch) {
		int i;
		
		// On parcours une nouvelle fois chaque index i jusqu'a � la longueur de tab mot
		// Si le caract�re est identique au caract�re � l'index i du tab mot
		
		for (i = 0; i<mot.length; i++) {
			if (ch == mot[i]) {
				// Cette �l�ment � l'index i prend la valeur true
				vu[i] = true;
			}
			
			/*
			 * else {
			 * 	vu[i] = false;
			}
			 */
			
			
		}
		
		return vu;
	}
	
// 4. Fin de partie
	
	boolean partieFinie (boolean vu []) {
		int i;
		for (i =0; i<vu.length; i++){
			if (vu[i] == false) {
			return false;
		     }
	    }
		return true;
	}
	
// 5 . Partie
	
	
	void partie (String mot) {
		
		// Je set mon tableau de boolean vu 
		// Il prend comme arguments ma m�thode motVersTab + le string mot qui contient le mot � deviner et sa taille
		boolean[] vu = new boolean[motVersTab(mot).length];
		
		// j'utilise ma m�thode affiche pour afficher les valeurs du tableaux ainsi que le mot cach� avec les ? 
		
		affiche(motVersTab(mot), vu);
		
		// J'utilise une loop while qui signifie que tant que ma partieFinie est false la partie continue
		
		// for (partieFinie(vu) == false) ne marche pas 
		while (partieFinie(vu) == false) {
		// Je d�clare mon Scanner qui va garder l'input de mon user en l'occurence un caract�re
		Scanner sc;
		System.out.println(" Veuillez entrez un carac�re : ");
		sc = new Scanner (System.in);
		
		// J'ai besoin de mon String qui contient le mot et des caract�res que mon user va taper donc j'utilise la m�thode charAt()
		String userInput = sc.next();
		char userCharInput = userInput.charAt(0);
		
		// j'update le tableau gr�ce � ma m�thode MAJ, � chaque fois que mon user tape un caract�re mon tab est maj 
		metAjour(motVersTab(mot) ,vu, userCharInput);
		
		// j'affiche une nouvelle fois mes tableaux apr�s cette maj 
		affiche(motVersTab(mot), (vu));
		
		// Si ma partie est finie je tape fin 
		if (partieFinie(vu)) {
			System.out.println("Fin de partie !");
		}
		
			}	
		
	}
	
	
	
	
}
