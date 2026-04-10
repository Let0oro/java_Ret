package clases;

import lombok.*;
import lombok.experimental.SuperBuilder;
import util.anotaciones.Entre;
import util.anotaciones.ExpReg;
import util.anotaciones.MaxDec;
import util.anotaciones.Min;

//@Data
@Getter
@Setter
@RequiredArgsConstructor // Also with @Data
@AllArgsConstructor // Also with @Data
@EqualsAndHashCode
@ToString
// @Accessors(chain = true) // Setters return this Object, also available with root/lombok.config > 'lombok.accessors.chain = true' (de forma global)

@SuperBuilder
public class Personaje2 {

    @ToString.Include(rank = -1)
    @Entre(desde = 0, hasta = 100, mensaje = "La posición x tiene que estar entre 0 y 100")
    @Builder.Default
    private int x = 0;

    @Entre(desde = 0, hasta = 100, mensaje = "La posición y tiene que estar entre 0 y 100")
    @Builder.Default
    private int y = 0;

    @Getter(AccessLevel.NONE) // None -> No se genera el getter
    @ExpReg(expReg = "[A-ZÑÁÉÍÓÚ]{2,}", mensaje = "El nombre del personaje tiene que tener al menos dos letras y estar en mayúculas")
    @NonNull
    public final String NOMBRE;

    @EqualsAndHashCode.Exclude
    @Min(minimo = 0, mensaje = "El ataque, como mínimo, tiene que ser superior a 0")
    @MaxDec(numeroDeDecimales = 1, mensaje = "El ataque tiene que tener, por lo menos, un decimal")
    @Builder.Default
    private double ataque = 0.0;

    private boolean isLeftTop(){
        return y == 0 && x == 0;
    }

    private boolean isLeftBottom(){
        return y == 100 && x == 0;
    }


    private boolean isRightTop(){
        return y == 0 && x == 100;
    }

    private boolean isRightBottom(){
        return y == 100 && x == 100;
    }

    private boolean isMiddle(){
        return y == 50 && x == 50;
    }



    private boolean isPosGiven(
            @Entre(desde = 0, hasta = 100, mensaje = "el primer parámetro tiene que estar entre 0 y 100") int a,
            @Entre(desde = 0, hasta = 100, mensaje = "el segundo parámetro tiene que estar entre 0 y 100") int b
    ) {
        return a == x && b == y;
    }
}