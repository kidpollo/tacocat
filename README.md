# Simple Microsoft Bot Framework example in Clojurescript

Using boot as a build tool.

## Prerequisites  

* To run you need to create a bot `https://dev.botframework.com/bots/provision` and get the Microsoft App Id and Password. Remember to save your password in a safe place. You'll need it multiple times.
* NodeJS `https://nodejs.org/en/download/`
* Boot `https://github.com/boot-clj/boot-cljs`
* Micrsosoft Bot Framwork Emulator `https://github.com/microsoft/botframework-emulator/wiki/Getting-Started` 

## Run localy

To run localy you need to run the boot build for dev which will watch any changes and compile js in `target`

    boot dev
  
In another terminal

    cd target
    node export MICROSOFT_APP_ID="_your-id_" && export MICROSOFT_APP_PASSWORD="_your-pass_"  &&  node main.js

Open the Bot Framework Emulator and point it to `http://localhost:3978/api/messages` and provide app id and password.

## Deploy to Heroku (Sorry Azure)

Create a heroku account and install the CLI `https://devcenter.heroku.com/articles/heroku-cli`

    heroku create
    heroku buildpacks:clear
    heroku buildpacks:add heroku/nodejs
    heroku buildpacks:add https://github.com/upworthy/heroku-buildpack-boot.git
    heroku config:set MICROSOFT_APP_ID="_your-id_" MICROSOFT_APP_PASSWORD=""_your-password_"
    git push heroku master
    
Configure your bot messaging endpoint `https://dev.botframework.com/bots/settings?id=you-bot`

    https://your-heroku-app.herokuapp.com/api/messages
    
    
