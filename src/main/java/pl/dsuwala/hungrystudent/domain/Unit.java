package pl.dsuwala.hungrystudent.domain;

import javax.persistence.*;

@Table(name = "unit")
@Entity
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(name = "shortcut_name")
    private String shortcutName;

    public Unit() {
    }

    public Unit(String name, String shortcutName) {
        this.name = name;
        this.shortcutName = shortcutName;
    }

    public String getName() {
        return name;
    }

    public String getShortcutName() {
        return shortcutName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setShortcutName(String shortcutName) {
        this.shortcutName = shortcutName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortcutName='" + shortcutName + '\'' +
                '}';
    }
}