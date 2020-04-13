import os
import sys
import pandas as pd
import numpy as np
import requests
import json

pathForData = "PlayerData.xlsx"

def isNaN(num):
    return num != num

def generate():
    playerData = pd.read_excel(pathForData)

    for ind in range(playerData.shape[0]):
        playerName = playerData.iloc[ind,0]
        playerShirtId = int(playerData.iloc[ind,1])
        playerType = playerData.iloc[ind,2]
        positionOfResponsibility = playerData.iloc[ind,3]
        team = playerData.iloc[ind,4]

        json_str={}
        if isNaN(positionOfResponsibility):
            json_str = {
                "playerName" : playerName,
                "playerShirtId" : playerShirtId,
                "playerType" : playerType,
                "team" : team
            }
        else:
            json_str = {
                "playerName" : playerName,
                "playerShirtId" : playerShirtId,
                "playerType" : playerType,
                "positionOfResponsibility" : positionOfResponsibility,
                "team" : team
            }

        command = "curl -X POST -H 'Content-type: application/json' --data '" + json.dumps(json_str) +  "' localhost:8080/players/createPlayer"
        os.system(command)

if __name__=="__main__":
    generate()