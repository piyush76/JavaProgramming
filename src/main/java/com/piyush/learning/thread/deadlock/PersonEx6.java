package com.piyush.learning.thread.deadlock;

/**
 * Created by piyush on 6/11/14.
 */
public class PersonEx6 {

    private String firstName;
    private String lastName;



    public PersonEx6(String name, String surname) {

        this.firstName = name;
        this.lastName = surname;

    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    /**
     * This method is prone to deadlock, especially if used by the class with the
     * {@code ThreadUtils.silentSleep(100);} uncommented.
     *
     * @param person
     * @deprecated <strong>DO NOT USE THIS METHOD</strong> as it is prone to deadlock.
     * Use the method betterVersionOfCopyFrom(Person) instead
     */

    public void copyFrom(final PersonEx6 person) {

        synchronized (this) {
            ThreadUtils.log("Aquired first lock" + Thread.currentThread().getName());
            synchronized (person) {
                ThreadUtils.log("Aquired second lock" + Thread.currentThread().getName());
                this.firstName = person.firstName;
                this.lastName = person.lastName;
            }
        }
    }


    /**
     * This method is not prone to deadlock and is thread safe too
     *
     * @param person
     */
    public void betterVersionOfCopyFrom(final PersonEx6 person) {
        final String name;
        final String surname;

        synchronized (person) {
            name = person.firstName;
            surname = person.lastName;
        }

        synchronized (this) {
            this.firstName = name;
            this.lastName = surname;
        }


    }





}
