package com.rockncode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.rockncode.Exceptions.AlbumNotAvailableException;
import com.rockncode.Exceptions.ConcertNotAvailableException;
import com.rockncode.Exceptions.InsufficientFundsException;
import com.rockncode.Exceptions.MerchandisingNotAvailableException;
import com.rockncode.Models.Album;
import com.rockncode.Models.Band;
import com.rockncode.Models.Concert;
import com.rockncode.Models.Fanatic;
import com.rockncode.Models.Item;
import com.rockncode.Models.Member;
import com.rockncode.Models.Order;
import com.rockncode.Models.Song;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) throws ConcertNotAvailableException, InsufficientFundsException {
        Scanner sc = new Scanner(System.in);

        List<Band> bands = new ArrayList<Band>();
        Band band1 = new Band("Rock n Code");
        bands.add(band1);

        do {
            System.out.println("..............SISTEMA INICIADO...............");
            System.out.println(".................ROCK & CODE.................\n");
            System.out.println("0. [FINALIZAR CONEXION]");
            System.out.println("1. [CREAR BANDA]");
            System.out.println("2. [Conectarse como Fan]");
            System.out.println(".............BANDAS DISPONIBLES..............\n");

            for (int i = 0; i < bands.size(); i++) {
                System.out.println((i + 3) + ". " + bands.get(i).getName());
            }
            System.out.println("\nELIGE PARA ADMINISTRAR: ");
            int index = sc.nextInt();
            if (index == 0) {
                System.out.println("..............CONEXION FINALIZADA...............");
                break;
            } else if (index == 1) {
                createBand(bands);
            } else if (index == 2) {
                fanaticOptions(bands);
            } else if (index > 1 && index <= bands.size() + 2) {
                do {
                    Band band = bands.get(index - 3);
                    List<String> options = new ArrayList<>();
                    options.add("Control de Banda");
                    options.add("Control de Conciertos");
                    options.add("Control de Albunes");
                    options.add("Control de Merchandising");

                    System.out.println("\nElige una opcion: ");
                    int select = select(options);
                    if (select == 0) {
                        System.out.println("..............CONEXION FINALIZADA...............");
                        break;
                    } else if (select > 0 && select <= options.size()) {
                        switch (select) {
                            case 1:
                                bandOptions(band);
                                break;

                            case 2:
                                concertOptions(band);
                                break;

                            case 3:
                                albumOptions(band);
                                break;

                            case 4:
                                merchandisingOptions(band);
                                break;

                            default:
                                System.out.println("ERROR: Opcion Invalida");
                                break;
                        }
                    }
                } while (true);
            } else {
                System.out.println("ERROR: Opcion Invalida");
            }

        } while (true);
    }

    private static int select(List options) {
        Scanner sc = new Scanner(System.in);
        System.out.println("0. [ATRAS]");
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
        return sc.nextInt();
    }

    private static void bandOptions(Band band) {
        List<String> options = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        options.add("Agregar Miembro");
        options.add("Eliminar Miembro");
        options.add("Cambiar Genero");
        options.add("Cambiar Historia");
        options.add("Mostrar Miembros");
        options.add("Mostrar Info");
        do {
            System.out.println("\n.............CONTROL DE BANDA..............\n");
            int select = select(options);
            if (select == 0) {
                return;
            } else if (select > 0 && select <= options.size()) {
                switch (select) {
                    case 1:
                        System.out.println("Nombre del miembro: ");
                        String name = sc.nextLine();

                        System.out.println("Instrumento del miembro: ");
                        String instrument = sc.nextLine();

                        System.out.println("Experiencia del miembro: ");
                        String experience = sc.nextLine();

                        Member member = new Member(name, instrument, experience);

                        band.addMember(member);

                        System.out.println("..........................................\n");
                        System.out.println("ESTADO: Miembro agregado correctamente");
                        System.out.println("..........................................\n");
                        break;

                    case 2:
                        try {
                            System.out.println("Nombre del miembro: ");
                            String name1 = sc.nextLine();

                            band.deleteMember(name1);

                            System.out.println("..........................................\n");
                            System.out.println("ESTADO: Miembro eliminado correctamente");
                            System.out.println("..........................................\n");
                        } catch (Exception e) {
                            System.out.println("..........................................\n");
                            System.out.println(e);
                            System.out.println("..........................................\n");
                        }

                        break;

                    case 3:
                        System.out.println("Nuevo genero: ");
                        String genre = sc.nextLine();
                        band.setGenre(genre);
                        System.out.println("..........................................\n");
                        System.out.println("ESTADO: Genero cambiado correctament");
                        System.out.println("..........................................\n");
                        break;

                    case 4:
                        System.out.println("Nueva historia: ");
                        String history = sc.nextLine();
                        band.setHistory(history);
                        System.out.println("..........................................\n");
                        System.out.println("ESTADO: Historia cambiada correctamente");
                        System.out.println("..........................................\n");
                        break;

                    case 5:
                        System.out.println("..........................................\n");
                        for (Member m : band.getMembers()) {
                            System.out.println(m.show());
                        }
                        System.out.println("..........................................\n");
                        break;

                    case 6:
                        System.out.println("..........................................\n");
                        System.out.println(band.toString());
                        System.out.println("..........................................\n");
                        break;

                    default:
                        System.out.println("..........................................\n");
                        System.out.println("ERROR: Opcion Invalida");
                        System.out.println("..........................................\n");
                        break;
                }
            }
        } while (true);
    }

    private static void concertOptions(Band band) {
        List<String> options = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        options.add("Programar Concierto");
        options.add("Ver Conciertos Programados");
        do {

            System.out.println("\n.............CONTROL DE CONCIERTOS..............\n");
            int select = select(options);
            if (select == 0) {
                return;
            } else if (select > 0 && select <= options.size()) {
                switch (select) {
                    case 1:
                        try {
                            System.out.println("Ingresa la fecha para el nuevo concierto (YYYY-MM-DD): ");
                            LocalDate date = LocalDate.parse(sc.nextLine());
                            Concert concert = band.scheduleConcert(date);
                            System.out.println("..........................................\n");
                            System.out.println(concert);
                            System.out.println("..........................................\n");
                        } catch (Exception e) {
                            System.out.println("..........................................\n");
                            System.out.println(e);
                            System.out.println("..........................................\n");
                        }
                        break;

                    case 2:
                        System.out.println("..........................................\n");
                        for (Concert c : band.getConcerts())
                            System.out.println(c.toString());
                        System.out.println("..........................................\n");
                        break;

                    default:
                        System.out.println("..........................................\n");
                        System.out.println("ERROR: Opcion Invalida");
                        System.out.println("..........................................\n");
                        break;
                }
            }
        } while (true);
    }

    private static void albumOptions(Band band) {
        List<String> options = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        options.add("Lanzar Album");
        options.add("Ver Albunes");
        options.add("Ver Canciones");
        do {
            System.out.println("\n.............CONTROL DE ALBUNES Y CANCIONES..............\n");
            int select = select(options);
            if (select == 0) {
                return;
            } else if (select > 0 && select <= options.size()) {
                switch (select) {
                    case 1:
                        try {
                            System.out.println("Ingresa el nombre del nuevo album: ");
                            String name = sc.nextLine();
                            if (!name.isEmpty()) {
                                System.out.println("Ingresa la fecha para el nuevo album (YYYY-MM-DD): ");
                                LocalDate date = LocalDate.parse(sc.nextLine());
                                System.out.println("Ingrese el precio del nuevo album: ");
                                double price = sc.nextDouble();
                                Album album = band.scheduleAlbum(name, date, price);
                                System.out.println("..........................................\n");
                                System.out.println(album);
                                System.out.println("..........................................\n");
                            } else {
                                System.out.println("ERROR: Ingrese un nombre");
                            }

                        } catch (Exception e) {
                            System.out.println("..........................................\n");
                            System.out.println(e);
                            System.out.println("..........................................\n");
                        }
                        break;

                    case 2:
                        System.out.println("..........................................\n");
                        for (Album a : band.getAlbums())
                            System.out.println(a.toString() + "\n");
                        System.out.println("..........................................\n");
                        break;

                    case 3:
                        System.out.println("..........................................\n");
                        for (Album a : band.getAlbums()) {
                            for (Song song : a.getSongs()) {
                                System.out.println(song.show());
                            }
                            System.out.println("");
                        }
                        System.out.println("..........................................\n");
                        break;

                    default:
                        System.out.println("..........................................\n");
                        System.out.println("ERROR: Opcion Invalida");
                        System.out.println("..........................................\n");
                        break;
                }
            }
        } while (true);
    }

    private static void merchandisingOptions(Band band) {
        List<String> options = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        options.add("Ver Productos");
        options.add("Lanzar Producto");
        options.add("Editar Producto");
        options.add("Ver/Cambiar Estado de los Pedidos");
        do {
            System.out.println("\n.............CONTROL DE MERCHANDISING..............\n");
            int select = select(options);
            if (select == 0) {
                return;
            } else if (select > 0 && select <= options.size()) {
                switch (select) {
                    case 1:
                        System.out.println("..........................................\n");
                        try {
                            for (Item i : band.getMerchandising()) {
                                System.out.println(i.toString());
                            }
                        } catch (Exception e) {
                            System.out.println("ERROR: No hay productos");
                        }

                        System.out.println("..........................................\n");
                        break;

                    case 2:
                        try {
                            System.out.println("..........................................\n");
                            System.out.println("Ingresa el nombre del producto: ");
                            String name = sc.nextLine();
                            if (name.isEmpty()) {
                                System.out.println("ERROR: Ingrese el nombre");
                                break;
                            }
                            System.out.println("Ingresa la descripcion: ");
                            String description = sc.nextLine();
                            if (description.isEmpty()) {
                                System.out.println("ERROR: Ingrese la descripcion");
                                break;
                            }
                            System.out.println("Ingresa la categoria: ");
                            String category = sc.nextLine();
                            if (category.isEmpty()) {
                                System.out.println("ERROR: Ingrese la categoria");
                                break;
                            }
                            System.out.println("Ingresa el precio: ");
                            double price = sc.nextDouble();
                            System.out.println("Ingrese cantidad disponible: ");
                            int disponibility = sc.nextInt();
                            Item item = new Item(name, category, description, price, disponibility);
                            if (band.addMerchandising(item)) {
                                System.out.println("..........................................\n");
                                System.out.println("STATUS: Producto creado correctamente");
                                System.out.println("..........................................\n");
                            }
                            System.out.println("..........................................\n");
                        } catch (Exception e) {
                            System.out.println("ERROR: " + e.getMessage());
                        }
                        break;

                    case 3:
                        try {
                            System.out.println("..........................................\n");
                            int select1 = select(band.getMerchandising());
                            if (select1 == 0) {
                                break;
                            }
                            Item item = band.getMerchandising().get(select1 - 1);
                            System.out.println("Elige un producto: ");
                            System.out.println("..........................................\n");
                            System.out.println("Ingresa el nombre del producto: ");
                            String name = sc.nextLine();
                            if (!name.isEmpty()) {
                                item.setName(name);
                            }
                            System.out.println("Ingresa la descripcion: ");
                            String description = sc.nextLine();
                            if (!description.isEmpty()) {
                                item.setDescription(description);
                            }
                            System.out.println("Ingresa la categoria: ");
                            String category = sc.nextLine();
                            if (!category.isEmpty()) {
                                item.setCategory(category);
                            }
                            System.out.println("Ingresa el precio: ");
                            double price = sc.nextDouble();
                            item.setPrice(price);
                            System.out.println("Ingrese cantidad disponible: ");
                            int disponibility = sc.nextInt();
                            item.setDisponibility(disponibility);

                            System.out.println("..........................................\n");
                            System.out.println("STATUS: Producto actualizado correctamente");
                            System.out.println("..........................................\n");

                            System.out.println("..........................................\n");
                        } catch (Exception e) {
                            System.out.println("ERROR: " + e.getMessage());
                        }
                        break;

                    case 4:
                        try {
                            int select1 = select(band.getOrders());
                            if (select1 == 0) {
                                break;
                            }
                            Order order = band.getOrders().get(select1 - 1);

                            System.out.println("..........................................\n");
                            System.out.println("Ingresa el nuevo estado del pedido: ");
                            String status = sc.nextLine();
                            if (!status.isEmpty()) {
                                order.setStatus(status);
                                System.out.println("..........................................\n");
                                System.out.println("STATUS: Pedido actualizado correctamente");
                                System.out.println("..........................................\n");
                            } else {
                                System.out.println("..........................................\n");
                                System.out.println("ERROR: Ingrese un nuevo estado");
                                System.out.println("..........................................\n");
                            }
                        } catch (Exception e) {
                            System.out.println("ERROR: " + e.getMessage());
                        }
                        break;

                    default:
                        System.out.println("..........................................\n");
                        System.out.println("ERROR: Opcion Invalida");
                        System.out.println("..........................................\n");
                        break;
                }
            }
        } while (true);
    }

    private static void fanaticOptions(List<Band> bands) {
        System.out.println("\n.............CONEXION COMO FAN..............\n");
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese su nombre");
        String name = sc.nextLine();
        if (name.length() > 0) {
            System.out.println("Ingrese su correo");
            String email = sc.nextLine();
            if (email.length() > 0) {
                System.out.println("Ingrese su ubicacion");
                String ubication = sc.nextLine();
                if (ubication.length() > 0) {
                    System.out.println("Ingrese sus redes sociales (Opcional)");
                    String socialNetworks = sc.nextLine();

                    Fanatic fan = new Fanatic(name, email, ubication, socialNetworks);

                    do {
                        System.out.println(".............. SELECT BAND ................");
                        System.out.println("0. [FINALIZAR CONEXION]");
                        for (int i = 0; i < bands.size(); i++) {
                            System.out.println((i + 1) + ". " + bands.get(i).getName());
                        }
                        int select = sc.nextInt();
                        if (select == 0) {
                            return;
                        } else if (select > 0 && select <= bands.size()) {
                            Band band = bands.get(select - 1);
                            do {
                                List<String> options = new ArrayList<>();
                                options.add("Comprar boleteria");
                                options.add("Comprar album");
                                options.add("Escribir reseña");
                                options.add("Comprar merchandising");
                                options.add("Asignar fondos");

                                System.out.println(".............. FAN DASHBOARD ................");
                                int select1 = select(options);
                                if (select1 == 0) {
                                    break;
                                } else if (select1 > 0 && select1 <= options.size()) {
                                    switch (select1) {
                                        case 1:
                                            try {
                                                System.out.println("..........................................\n");
                                                if (fan.buyTicket(band)) {
                                                    System.out.println("..........................................\n");
                                                    System.out.println("STATUS: Compra realizada con exito");
                                                    System.out.println("..........................................\n");
                                                } else {
                                                    System.out.println("..........................................\n");
                                                    System.out.println("STATUS: Compra fallida");
                                                    System.out.println("..........................................\n");
                                                }
                                            } catch (ConcertNotAvailableException | InsufficientFundsException e) {
                                                System.out.println(e.getMessage());
                                            } catch (Exception e) {
                                                throw new RuntimeException(e);
                                            }
                                            break;

                                        case 2:
                                            try {
                                                System.out.println("..........................................\n");
                                                if (fan.buyAlbum(band)) {
                                                    System.out.println("..........................................\n");
                                                    System.out.println("STATUS: Compra realizada con exito");
                                                    System.out.println("..........................................\n");
                                                } else {
                                                    System.out.println("..........................................\n");
                                                    System.out.println("STATUS: Compra fallida");
                                                    System.out.println("..........................................\n");
                                                }
                                            } catch (AlbumNotAvailableException | InsufficientFundsException e) {
                                                System.out.println(e.getMessage());
                                            } catch (Exception e) {
                                                throw new RuntimeException(e);
                                            }
                                            break;

                                        case 3:
                                            try {
                                                System.out.println("..........................................\n");
                                                if (fan.writeReview(band)) {
                                                    System.out.println("..........................................\n");
                                                    System.out.println("STATUS: Review realizada con exito");
                                                    System.out.println("..........................................\n");
                                                } else {
                                                    System.out.println("..........................................\n");
                                                    System.out.println("STATUS: Review fallida");
                                                    System.out.println("..........................................\n");
                                                }

                                            } catch (AlbumNotAvailableException e) {
                                                System.out.println(e.getMessage());
                                            }
                                            break;

                                        case 4:
                                            try {
                                                System.out.println("..........................................\n");
                                                if (fan.buyMerchandising(band)) {
                                                    System.out.println("..........................................\n");
                                                    System.out.println("STATUS: Compra realizada con exito");
                                                    System.out.println("..........................................\n");
                                                } else {
                                                    System.out.println("..........................................\n");
                                                    System.out.println("STATUS: Compra fallida");
                                                    System.out.println("..........................................\n");
                                                }

                                            } catch (MerchandisingNotAvailableException
                                                    | InsufficientFundsException e) {
                                                System.out.println(e.getMessage());
                                            }
                                            break;

                                        case 5:
                                            try {
                                                System.out.println("..........................................\n");
                                                System.out.println("¿Cuantos fondos desea agregar?: ");
                                                double balance = sc.nextDouble();
                                                fan.addFunds(balance);
                                            } catch (Exception e) {
                                                System.out.println(e.getMessage());
                                            }

                                            break;
                                        default:
                                            System.out.println("..........................................\n");
                                            System.out.println("ERROR: Opcion Invalida");
                                            System.out.println("..........................................\n");
                                            break;
                                    }
                                } else {
                                    System.out.println("ERROR: Opcion Invalida");
                                }
                            } while (true);
                        }
                    } while (true);
                } else {
                    System.out.println("ERROR: Ingrese su ubicacion");
                }
            } else {
                System.out.println("ERROR: Ingrese su email");
            }
        } else {
            System.out.println("ERROR: Ingrese su nombre");
        }
    }

    private static void createBand(List<Band> bands) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\n.............CREACION DE BANDA..............\n");
            System.out.println("[ENTER PARA SALIR]\n");
            System.out.println("Ingrese nombre de la Banda");
            String name = sc.nextLine();
            if (!name.isEmpty()) {
                Band band = new Band(name);
                bands.add(band);
                System.out.println("Ingrese genero de la banda (Opcional)");
                String genre = sc.nextLine();
                if (!genre.isEmpty()) {
                    band.setGenre(genre);
                }

                System.out.println("Ingrese historia de la banda (Opcional)");
                String history = sc.nextLine();
                if (!genre.isEmpty()) {
                    band.setHistory(history);
                }
                System.out.println("..........................................\n");
                System.out.println("STATUS: Banda " + band.getName() + " creada satisfactoriamente");
                System.out.println("..........................................\n");
            }
            System.out.println("..........................................\n");
            System.out.println("STATUS: Creacion de bandas finalizada");
            System.out.println("..........................................\n");
            break;
        } while (true);
    }
}
