package ru.stqa.pft.addressbook.model;

public class GroupData {
    public void setId(int id) {
        this.id = id;
    }

    private int id;
    private final String groupName;
    private final String header;
    private final String footer;

    public GroupData(String groupName, String header, String footer) {
        this.id = 0;
        this.groupName = groupName;
        this.header = header;
        this.footer = footer;
    }
    public GroupData(int id, String groupName, String header, String footer) {
        this.id = id;
        this.groupName = groupName;
        this.header = header;
        this.footer = footer;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getHeader() {
        return header;
    }

    public String getFooter() {
        return footer;
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "id='" + id + '\'' +
                ", groupName='" + groupName + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupData groupData = (GroupData) o;

        if (id != groupData.id) return false;
        return groupName != null ? groupName.equals(groupData.groupName) : groupData.groupName == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
        return result;
    }
}
