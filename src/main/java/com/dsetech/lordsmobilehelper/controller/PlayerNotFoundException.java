package com.dsetech.lordsmobilehelper.controller;

class PlayerNotFoundException extends RuntimeException {

    PlayerNotFoundException(Long id) {
        super("Could not find Player " + id);
    }
}