package Problems;

import org.jetbrains.annotations.NotNull;

/**
 * Enumération représentant les niveaux de difficulté d'un problème.
 * Les niveaux disponibles sont : EASY, MEDIUM, HARD.
 */
public enum ProblemDifficulty {
    EASY,
    MEDIUM,
    HARD;

    /**
     * Convertit une chaîne de caractères en une valeur correspondante de {@code ProblemDifficulty}.
     * La méthode ne fait pas de distinction de casse.
     *
     * @param difstr La chaîne de caractères représentant la difficulté, non nulle et non sensible à la casse.
     * @return L'instance de {@code ProblemDifficulty} correspondante.
     * @throws IllegalArgumentException si la chaîne donnée ne correspond à aucune difficulté.
     */
    public static ProblemDifficulty fromString(@NotNull String difstr) {
        return ProblemDifficulty.valueOf(difstr.toUpperCase());
    }

    /**
     * Retourne la représentation en chaîne de caractères de la difficulté.
     * La chaîne retournée est en minuscules.
     *
     * @return Une chaîne de caractères en minuscules représentant la difficulté.
     */
    @Override
    public @NotNull String toString() {
        return name().toLowerCase();
    }
}
