package com.mycompany.app;
import java.util.Objects;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.EnumMap;
import java.util.Optional;
import java.util.stream.Collectors;


/** Usuario: contactos + sus bandejas de correo. */
public class Usuario {
private final String nombre;
private final String email;


// RF-03: gestión de contactos "del usuario"
private final List<Contacto> contactos = new ArrayList<>();


// RF-06: bandejas
private final Map<Carpeta, List<Email>> bandejas = new EnumMap<>(Carpeta.class);


public Usuario(String nombre, String email){
this.nombre = Objects.requireNonNull(nombre);
this.email = Objects.requireNonNull(email);
for (Carpeta c : Carpeta.values()) bandejas.put(c, new ArrayList<>());
// me agrego a mí mismo como contacto por conveniencia
contactos.add(new Contacto(nombre, email));
}


public String getNombre(){ return nombre; }
public String getEmail(){ return email; }


/* ==== RF-03: Contactos ==== */
public void agregarContacto(Contacto c){ contactos.add(c); }
public boolean eliminarContactoPorNombre(String nombre){
return contactos.removeIf(c -> c.getNombre().equalsIgnoreCase(nombre));
}
public Optional<Contacto> buscarContactoPorNombre(String nombre){
// USO DE filter: filtra por nombre (ignora mayúsculas/minúsculas)
return contactos.stream()
.filter(c -> c.getNombre().equalsIgnoreCase(nombre))
.findFirst();
}
public int cantidadDeContactos(){
return contactos.size();
}
public List<Contacto> verContactos(){ return List.copyOf(contactos); }


/* ==== RF-06: Bandejas ==== */
public void agregarACarpeta(Carpeta carpeta, Email email){ bandejas.get(carpeta).add(email); }
public List<Email> ver(Carpeta carpeta){ return List.copyOf(bandejas.get(carpeta)); }
public boolean mover(Email email, Carpeta desde, Carpeta hacia){
List<Email> src = bandejas.get(desde);
if (src.remove(email)) { bandejas.get(hacia).add(email); return true; }
return false;
}
public boolean eliminar(Email email, Carpeta desde){ return mover(email, desde, Carpeta.ELIMINADOS); }
public boolean restaurar(Email email){ return mover(email, Carpeta.ELIMINADOS, Carpeta.ENTRADA); }


/* ==== RF-04: Búsqueda en ENTRADA ==== */
public List<Email> buscarEnEntrada(String texto){
String q = (texto == null ? "" : texto).toLowerCase();
// USO DE filter: queda SOLO lo que coincide con el texto
// USO DE map: transformamos contactos (destinatarios) a sus emails/nombres para comparar
return bandejas.get(Carpeta.ENTRADA).stream().filter(e ->
e.getAsunto().toLowerCase().contains(q) ||
e.getContenido().toLowerCase().contains(q) ||
e.getRemitente().getEmail().toLowerCase().contains(q) ||
e.getPara().stream().map(Contacto::getEmail).anyMatch(mail -> mail.toLowerCase().contains(q)) ||
e.getPara().stream().map(Contacto::getNombre).anyMatch(nom -> nom.toLowerCase().contains(q))
).collect(Collectors.toList());
}
}