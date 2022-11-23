package it.unisa.school;

public class Person {

    final private String name;
    final private String surname;
    final private int birthYear;
    private String userID;
    private String password;

    public Person(String name, String surname, int birthYear,String userID, String password) {
        if(userID.contains(" ")) throw  new IllegalArgumentException("L'ID utente non può contenere spazi");
        if(userID.length() < 5) throw new IllegalArgumentException("L'ID utente deve essere almeno 5 caratteri");
        if(password.contains(" ")) throw new IllegalArgumentException("La password non può contenere spazi");
        if(password.length() < 5) throw new IllegalArgumentException("La password deve essere almeno 5 caratteri");
        if(name == null || name.isEmpty()) throw new IllegalArgumentException("Il campo è nome è vuoto");
        if(surname == null || surname.isEmpty()) throw new IllegalArgumentException(("Il campo cognome è vuoto"));
        if(birthYear < 1900) throw new IllegalArgumentException("L'anno di nascita è invalido");

        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
        this.userID = userID;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String getUserID(){ return userID; }

    public String getPassword() { return password; }

    public void setPassword(String newPassword)
    {
        if(newPassword.length() < 5 || newPassword.contains(" "))
            throw new IllegalArgumentException("Formattazione nuova password non valida (lunghezza > 5 e assenza di spazi).");
        else
            this.password = newPassword;
    }

    public void setUserID(String newUserID)
    {
        if(newUserID.length() < 5 || newUserID.contains(" "))
            throw new IllegalArgumentException("Formattazione nuovo UserID non valida (lunghezza > 5 e assenza di spazi).");
        else
            this.userID = newUserID;
    }
    @Override
    public String toString() {
        return "Nome='" + name + '\'' +
                ", Cognome='" + surname + '\'' +
                ", Anno di nascita=" + birthYear;
    }
}
