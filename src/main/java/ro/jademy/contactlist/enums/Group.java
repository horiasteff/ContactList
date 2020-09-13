package ro.jademy.contactlist.enums;

public enum Group {

    CONTACTS("MY CONTACTS"),
    FAVORITE("FAVORITE"),
    FAMILY("FAMILY"),
    WORK("WORK");

    Group(String groupName) {
        this.groupName=groupName;
    }

    private String groupName;

    public String getGroupName() {
        return groupName;
    }
}
