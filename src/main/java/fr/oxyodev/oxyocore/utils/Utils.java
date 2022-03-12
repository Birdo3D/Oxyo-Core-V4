package fr.oxyodev.oxyocore.utils;

public class Utils {

    public static GeneratorTier getTierByIndex(int index) {
        for (GeneratorTier generatorTier : GeneratorTier.values())
            if (generatorTier.getIndex() == index)
                return generatorTier;
        return null;
    }
}
