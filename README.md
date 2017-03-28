# WFbot
Scan @WarframeAlerts twitter for alert missions with worthwhile rewards. 

Warframe has frequent limited-time missions with varying rewards. Each time a new alert mission is created, the @WarframeAlerts twitter posts a notification.

Many of the rewards aren't worth doing the mission for, however.
This bot uses the Twitter4J library to scan for tweets that contain keywords (stored in a .txt file) pertaining to different rewards. 
When a new tweet is posted, if it contains any of the keywords, the bot uses the Discord4J api to send an update to my Warframe server on Discord. 

Twitter4J: http://twitter4j.org/en/

Discord4J: https://github.com/austinv11/Discord4J



Discord dev link: https://discordapp.com/developers/docs/intro

Go here to create an app for discord and get the token you'll need to connect. In discord, enable dev mode and right click text channel to get the channel id. 

Twitter dev link: https://apps.twitter.com/

go here to create an app for twitter and get the consumer key/secret as well as access token/secret. 
