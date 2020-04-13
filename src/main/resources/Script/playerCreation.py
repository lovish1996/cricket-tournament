# Run the command "python3 src/main/resources/Script/playerCreation.py <DataFileName>" from the project root directory for running the script
import os
import sys
import pandas as pd
import requests
import json


host = "localhost"
port= "8080"
apiEndPoint = "/players/createPlayer"

def isNaN(num):
    return num != num

def generate(fileName):

    pathForData = "src/main/resources/Data/"+fileName
    playerData = pd.read_excel(pathForData)

    # API to hit the post request
    apiToHit = host + ":" + port + apiEndPoint

    for ind in range(playerData.shape[0]):
        playerName = playerData.iloc[ind,0]
        playerShirtId = int(playerData.iloc[ind,1])
        playerType = playerData.iloc[ind,2]
        positionOfResponsibility = playerData.iloc[ind,3]
        teamName = playerData.iloc[ind,4]

        json_str={}
        if isNaN(positionOfResponsibility):
            json_str = {
                "playerName" : playerName,
                "playerShirtId" : playerShirtId,
                "playerType" : playerType,
                "teamName" : teamName
            }
        else:
            json_str = {
                "playerName" : playerName,
                "playerShirtId" : playerShirtId,
                "playerType" : playerType,
                "positionOfResponsibility" : positionOfResponsibility,
                "teamName" : teamName
            }
            
        command = "curl -X POST -H 'Content-type: application/json' --data '" + json.dumps(json_str) +  "' " + apiToHit
        os.system(command)

if __name__=="__main__":
    fileName = sys.argv[1]
    generate(fileName)