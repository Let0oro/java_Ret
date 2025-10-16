import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import static lib.in.leerChar;
import static lib.in.leerLine;

public class Main {

    public static String[] techs = {"HTMl", "CSS", "JS", "React", "React Native", "Vue", "Angular", "Next", "Express", "MongoDB", "PostgreSQL", "Rust"};

    public static void main(String[] args) {

        char isMasc;
        char genreRecruiter;
        String nameRecruiter, titleJob, techList, extraTechListChar;
        StringBuilder extraTechList = new StringBuilder();
        HashMap<Character, String> techMap = genMap();

        isMasc = leerChar("El reclutador es hombre(s/n)?: ", v -> "snSN".contains(v + ""), "Please, just type 's' or 'n'");
        genreRecruiter = (isMasc + "").equalsIgnoreCase("s") ? 'o' : 'a';

        nameRecruiter = leerLine("Nombre del reclutador: ");

        titleJob = leerLine("Título del puesto: ");

        techList = leerLine("Tecnologías principales del puesto: ");

        System.out.println("Tecnologías extra a destacar:");
        System.out.println("(escribe los carácteres juntos como un texto normal)");

        for (int i = 0; i < techs.length; i++) {
            Character[] keys = techMap.keySet().toArray(new Character[0]);
            System.out.printf("%s[%s] ", techs[i], keys[i]);
        }
        System.out.println();

        extraTechListChar = leerLine("-> ");
        extraTechListChar = extraTechListChar.trim();

        int len = extraTechListChar.length();
        for (int i = 0; i < len; i++) {
            char ch = extraTechListChar.charAt(i);
            String techValue = techMap.get(ch);
            if (techValue == null) continue;
            if (extraTechListChar.substring(0, i == 0 ? 0 : i - 1).contains(techValue)) continue;
            if (i == len - 1) {
                extraTechList.append(" y ");
            } else if (i > 0) extraTechList.append(", ");
            extraTechList.append(techValue);
        }

        System.out.println(extraTechList);

        genRedaction(genreRecruiter, nameRecruiter, titleJob, techList, extraTechList.toString().trim());
    }

    public static HashMap<Character, String> genMap() {
        HashMap<Character, String> techMap = new HashMap<>();

        for (int tech = 0; tech < techs.length; tech++) {
            techMap.put((char) ('a' + tech), techs[tech]);
        }

        return techMap;
    }

    public static void genRedaction(char genre, String name, String title, String techList, String extraTech) {
        StringBuilder str = new StringBuilder();

        String nextP = "Estimad%s %s,\n";

        str.append(String.format(nextP, genre, name));

        nextP = "Me dirijo a usted con entusiasmo para postularme al puesto de %s especializado en %s. Con formación profesional y experiencia práctica en tecnologías clave como %s, estoy seguro de que puedo ser un valioso miembro de su equipo.\n\n";

        str.append(String.format(nextP, title, techList, extraTech));

        str.append(String.format("Como %s, ", title));
        nextP = "he tenido la oportunidad de liderar y participar en proyectos desafiantes, como un sistema de tracking en tiempo real con React Native, donde combiné mi habilidad técnica y mi creatividad para entregar soluciones efectivas e innovadoras. Además, mi formación en programación, incluida la obtención de un máster como Full-Stack Developer en ThePower y RockTheCode, junto al grado superior en Desarrollo de Aplicaciones Multiplataforma de Retamar, ha forjado mi compromiso con el aprendizaje continuo, permitiendo adaptarme rápidamente a las tecnologías y metodologías más avanzadas.\n\n";
        str.append(nextP);

        nextP = "Estoy profundamente motivado por la idea de contribuir al crecimiento de vuestro proyecto, aplicando mis conocimientos y habilidades para materializar vuestra visión de negocio. A su vez, veo esta oportunidad como una vía para seguir evolucionando profesionalmente y alcanzar juntos resultados de alto impacto.\n\n";
        str.append(nextP);

        nextP = "Agradezco mucho su atención y quedo a su disposición para ampliar información sobre mis competencias o coordinar una entrevista. Me encantaría compartir más acerca de cómo mi experiencia y pasión por la programación pueden contribuir a la mejora del equipo.\n\n";
        str.append(nextP);

        nextP = "Reciba un cordial saludo,\n\n";
        str.append(nextP);

        nextP = "Juan Manuel Montero Benavides";
        str.append(nextP);

        String content = str.toString();

        // Imprimir por consola
        System.out.println(content);

        // Guardar en archivo .txt
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("redaccion.txt"))) {
            writer.write(content);
//            System.out.println("Archivo redaccion.txt guardado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

//
//    public static void genRedaction(char genre, String name, String title, String techList, String extraTech) {
//        StringBuilder str = new StringBuilder();
//
//        String nextP = "Estimad%s %s,\n";
//
//        str.append(String.format(nextP, genre, name));
//
//        nextP = "Me dirijo a usted con entusiasmo para postularme al puesto de %s especializado en %s. Con formación profesional y experiencia práctica en tecnologías clave como %s, estoy seguro de que puedo ser un valioso miembro de su equipo.\n\n";
//
//        str.append(String.format(nextP, title, techList, extraTech));
//
//        str.append(String.format("Como %s, ", title));
//        nextP = "he tenido la oportunidad de liderar y participar en proyectos desafiantes, como un sistema de tracking en tiempo real con React Native, donde combiné mi habilidad técnica y mi creatividad para entregar soluciones efectivas e innovadoras. Además, mi formación en programación, incluida la obtención de un máster como Full-Stack Developer en ThePower y RockTheCode, junto al grado superior en Desarrollo de Aplicaciones Multiplataforma de Retamar, ha forjado mi compromiso con el aprendizaje continuo, permitiendo adaptarme rápidamente a las tecnologías y metodologías más avanzadas.\n\n";
//        str.append(nextP);
//
//        nextP = "Estoy profundamente motivado por la idea de contribuir al crecimiento de vuesto proyecto, aplicando mis conocimientos y habilidades para materializar vuestra visión de negocio. A su vez, veo esta oportunidad como una vía para seguir evolucionando profesionalmente y alcanzar juntos resultados de alto impacto.\n\n";
//        str.append(nextP);
//
//        nextP = "Agradezco mucho su atención y quedo a su disposición para ampliar información sobre mis competencias o coordinar una entrevista. Me encantaría compartir más acerca de cómo mi experiencia y pasión por la programación pueden contribuir a la mejora del equipo.\n\n";
//        str.append(nextP);
//
//        nextP = "Reciba un cordial saludo,\n\n";
//        str.append(nextP);
//
//        nextP = "Juan Manuel Montero Benavides";
//        str.append(nextP);
//    }

}