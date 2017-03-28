# WFbot
Scan @WarframeAlerts twitter for alert missions with worthwhile rewards. 

Warframe has frequent limited-time missions with varying rewards. Each time a new alert mission is created, the @WarframeAlerts twitter posts a notification.
Many of the rewards aren't worth doing the mission for, however.
This bot uses the Twitter4J library to scan for tweets that contain keywords (stored in a .txt file) pertaining to different rewards. 
When a new tweet is posted, if it contains any of the keywords, the bot uses the Discord4J api to send an update to my Warframe server on Discord. 

Twitter4J: http://twitter4j.org/en/
Discord4J: https://github.com/austinv11/Discord4J
