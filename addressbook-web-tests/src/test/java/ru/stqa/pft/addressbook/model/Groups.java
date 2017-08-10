package ru.stqa.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.Set;

/**
 * Created by bardina_md on 10.08.17.
 */
public class Groups extends ForwardingSet <GroupData> {

    private Set <GroupData> delegate;

    @Override
    protected Set<GroupData> delegate() {
        return null;
    }

    public Groups ()
}
