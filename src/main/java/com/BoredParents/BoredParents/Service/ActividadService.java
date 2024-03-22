package com.BoredParents.BoredParents.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.BoredParents.BoredParents.Entities.Actividad;

@Service
public class ActividadService {
    // Lista para almacenar las actividades
    public List<Actividad> listaActividades = new ArrayList<>();
    public List<Actividad> ActividadesNoElectricas = new ArrayList<>();
    public List<Actividad> ActividadesBaratas = new ArrayList<>();
    public List<Actividad> ActividadesRecreativas = new ArrayList<>();
    // Constructor
    public ActividadService() {
        
        
        // Agregar actividades al inicializar el servicio
        
        //Muñoz
        listaActividades.add(new Actividad(1, "Clasificación por colores", "Proporciona objetos de distintos colores y pide al niño que los clasifique por color", "Educativa"));
        listaActividades.add(new Actividad(2, "Lectura de cuentos", "Lee Cuentos cortos y animados que estimulen la imaginación y el lenguaje", "Educactiva"));
        listaActividades.add(new Actividad(3, "Juego de Parejas", "Haz tarjetas con imágenes y pide al niño que encuentre las parejas correspondientes", "Educativa"));
        listaActividades.add(new Actividad(4, "Pintura con los dedos", "Deja que los niños exploren distintas texturas y colores mientras pintan con los dedos", "Educativa"));
        listaActividades.add(new Actividad(5, "Juego de construcción", "Uso de bloques de construcción para fomentar la creatividad y la habilidad motora", "Educativa"));
        //Sanchez
        ActividadesNoElectricas.add(new Actividad(4, "Crear collares con pasta", "Los niños pueden pintar la pasta de diferentes colores y luego ensartarla en un hilo para hacer collares. Estos pueden ser regalos para familiares queridos", "No electricos"));
        ActividadesNoElectricas.add(new Actividad(5, "Jugar a encontrar formas en las nubes", " Los niños pueden acostarse en el césped y buscar formas en las nubes. Podrían incluso dibujar lo que ven para compartirlo con los demás", "No electricos"));
        ActividadesNoElectricas.add(new Actividad(6, "Hacer un picnic en el suelo de la sala de estar con mantas y almohadas", "Los niños pueden ayudar a preparar los bocadillos y luego disfrutar de un picnic en casa. Podrían incluso invitar a sus juguetes a unirse a ellos", "No electricos"));
        ActividadesNoElectricas.add(new Actividad(7, "Hacer caretas de animales", "Con platos de papel y palos de paleta los niños dibujaran su anial favorito en los platos de papel y luego los usaran par un show improvisado para la familia", "No electricos"));
        ActividadesNoElectricas.add(new Actividad(8, "Crear libro de recortes", "Con imagenes de revista y pegante los niños recortatran imagenes de sus cosas favoritas y las pegaran en un cuaderno para hacer su propio libro de recortes", "No electricos"));
        //Guevara
        ActividadesBaratas.add(new Actividad(8, "Canciones y rimas infantiles"," Al cantar canciones y rimas, los niños mejoran su memoria y aprenden nuevos vocabularios. ", "Bajo Costo"));
        ActividadesBaratas.add(new Actividad(9, "Juegos de clasificación"," Utilizar objetos de diferentes colores, formas o tamaños para que el niño los clasifique. ",  "Bajo CostoS"));
        ActividadesBaratas.add(new Actividad(10, "Puzzles y rompecabezas sencillos", "Estos juegos promueven la resolución de problemas y la percepción visual-espacial. ", "Bajo Costo"));
        ActividadesBaratas.add(new Actividad(12, "Juegos de memoria", "Desde juegos de cartas de memoria hasta encontrar parejas de objetos similares, estos juegos mejoran la concentración y la memoria a corto plazo.", "Bajo Costo"));
        ActividadesBaratas.add(new Actividad(13, "Juegos de sombras", "Usar las manos o figuras para crear sombras en la pared con una linterna. Esta actividad estimula la imaginación y enseña conceptos básicos de la física, como la luz y la sombra.", "Bajo Costo"));
        //Mendivelso
        ActividadesRecreativas.add(new Actividad(14,"Juegos de pelota","Les proponemos algunos como el fútbol o el ponchado. O actividades como encestar, lanzar y atrapar la pelota.", "Recreativas"));
        ActividadesRecreativas.add(new Actividad(15,"Cuerdas",", se emplea una cuerda que esté doblada de manera que alcance aproximadamente a los hombros. La persona sostiene la cuerda con ambas manos, con cada extremo en una mano, dejándola colgar detrás de ella antes de comenzar a saltar.", "Recreativas"));
        ActividadesRecreativas.add(new Actividad(16,"Aros","Los niños pueden saltar dentro y fuera de ellos, además de hacerlos girar alrededor de su cintura. También, pueden colocar los aros en el suelo y pasar sobre ellos saltando.", "Recreativas"));
        ActividadesRecreativas.add(new Actividad(17,"Baile",": Pon música y organiza una sesión de baile.", "Recreativas"));

    }
    //muñoz

    // Método para obtener la lista de actividades
    public List<Actividad> obtenerListaActividades() {
        return listaActividades;
    }
    //Sanchez
    public List<Actividad> obtenerActividadesNoElectricas() {
        return ActividadesNoElectricas;
    }
    //Guevara
    public List<Actividad> obtenerActividadesBaratas() {
        return ActividadesBaratas;
    }
    
    public List<Actividad> obtenerActividadesRecreActividades() {
        return ActividadesRecreativas;
    }
}