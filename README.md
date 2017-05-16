# Simple Microsoft Bot Framework example in Clojurescript

## Prerequisites

* To run you need to create a bot `https://dev.botframework.com/bots/provision` and get the Microsoft App Id and Password. Remember to save your password in a safe place. You'll need it multiple times.
* NodeJS `https://nodejs.org/en/download/`
* Boot `https://github.com/boot-clj/boot-cljs`
* Micrsosoft Bot Framwork Emulator `https://github.com/microsoft/botframework-emulator/wiki/Getting-Started` 

## Run

To run localy you need to run the boot build for dev which will watch any changes and compile js in `target`

    boot dev
  
In another terminal

    cd target
    node export MICROSOFT_APP_ID="_your-id_" && export MICROSOFT_APP_PASSWORD="_your-pass_"  &&  node main.js

Open the Bot Framework Emulator and point it to `http://localhost:3978/api/messages` and provide app id and password.

