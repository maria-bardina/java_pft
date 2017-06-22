package ru.stqa.pft.addressbook.model;

public class GroupData {

    private int id = Integer.MAX_VALUE;
    private String Name;
    private String header;
    private String footer;



    public String getGroupName() {
        return Name;
    }

    public String getHeader() {
        return header;
    }

    public String getFooter() {
        return footer;
    }

    public GroupData withId(int id) {
        this.id = id;
        return this;
    }

    public GroupData withName(String Name) {

        this.Name = Name;
        return this;
    }

    public GroupData withHeader(String header) {
        this.header = header;
        return this;
    }

    public GroupData withFooter(String footer) {
        this.footer = footer;
        return this;
    }

    public int getId() {
        return id;
    }
    @Override
    public String toString() {
        return "GroupData{" +
                "id='" + id + '\'' +
                ", groupName='" + Name + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupData groupData = (GroupData) o;

        return Name != null ? Name.equals(groupData.Name) : groupData.Name == null;
    }

    @Override
    public int hashCode() {
        return Name != null ? Name.hashCode() : 0;
    }

}
