const express = require("express");
const cors = require ("cors");
const mysql = require ("mysql2");
const fs = require("fs");

const app = express();

/*var con  = mysql.createConnection ({
    host: "labs.inspedralbes.cat",
    user: "a21marsanbla_grup3",
    password: "Projecte123",
    database: "a21marsanbla_project"
});*/

const bdParams = {
    host: "labs.inspedralbes.cat",
    user: "a21marsanbla_grup3",
    password: "Projecte123",
    database: "a21marsanbla_project"
}

/*con.connect(function(err){
    if(err) throw err;
    else{
        console.log("Successfully connected");

        let sql = "SELECT * FROM usuari WHERE "





    }
});*/
app.use(cors(
    {
        origin: function(origin, callback){
            return callback(null, true);
        }
    }
));



//autetificació de Usuari.
app.get("/auth/:user/:pwd", (req, res) => {

    let user = req.params.user;
    let password = req.params.pwd;

    iplog(user,req);
    let config = {
        auth: false,
        role: "",
    };

    let con = mysql.createConnection(bdParams);

    con.connect(function(err){
        if(err) throw err;
        else {
            let sql = "SELECT * FROM usuari WHERE nom = '" + user + "' AND PASS = '" + password + "'";
            console.log(sql);
            con.query(sql, function (err, result, fields){
                if(err) throw err;
                if(result.length == 0){
                    //console.log("No existeix l'usuari. Crea't un compte abans.")
                    config.text = "No existeix l'usuari. Crea't un compte abans.";
                } else if (result.length > 1){
                    //console.log("Alguna cosa ha anat malament.")
                    config.text = "Alguna cosa ha anat malament.";
                } else {
                    let row = result[0];
                    config.auth = true;
                    config.role = row.ROL;
                    //console.log(row.nick + ", " + row.rol);
                }

                let str = JSON.stringify(config);
                res.send(str);
            });

            con.end(function(err) {
                if (err){
                    return console.log('error:' + err.message);
                }
            });
        }
    });
});




//Creacio de nou usuari
app.get("/create/:user/:pwd", (req, res) => {
    console.log("ha entrat a creacio");
    let user = req.params.user;
    let password = req.params.pwd;
    let email=req.params.email;
    

    let creation = {
        text: ""
    };

    if(userExists(user)){
        creation.text = "Ja existeix un usuari amb aquests paràmetres, canvia el nom siusplau";
        console.log("H entrat a user exist");
    } else {
        insertUser(user,password,email);
        console.log("Ha entrat a user inset user");
    }
    
    let str = JSON.stringify(creation);
    res.send(str);
});




//Funcions de suport
//CHECK IF USER EXIST
function userExists (nom) {

    
    let exist;
    let con = mysql.createConnection(bdParams);

    con.connect(function(err){
        if(err) throw err;
        else {
            
            let sql = "SELECT * FROM usuari WHERE nom = '" + nom + "'";
            con.query(sql, function (err, result, fields){
                if(err) throw err;
                if(result.length == 0){
                    exist = false;
                } else {
                    exist = true;
                }
            });

            con.end(function(err) {
                if (err){
                    return console.log('error:' + err.message);
                }
            });
        }
        return exist;


        

    });
}


//INSERT USER
function insertUser(nom, password,email){
    
    
    let insertOK;
    let con = mysql.createConnection(bdParams);

    con.connect(function(err){
        if(err) throw err;
        else {

            let sql = "INSERT INTO usuari (ID,NOM,PASS,MAIL) VALUES (2,'" + nom + "', '" + password + "','"+email+"')";

            con.query(sql, function (err, result){
                if(err) throw err;
                if(result.affectedRows == 1){
                    insertOK = true;
                } else {
                    insertOK = false;
                }

                con.end(function(err) {
                    if (err){
                        return console.log('error:' + err.message);
                    }
                });
            });
        }
        return insertOK;
    });
}


//Borrar usuari
app.get("/delete/:userID", (req, res) => {

    let id = req.params.userID;
    
    con.connect(function (err){
        if(err) throw err;
        else {
            let sqlDelete = "DELETE FROM usuari WHERE ID = " + id;
            con.query(sqlDelete, function (err, result){
                if (err) throw err;
                if (result.affectedRows == 0){
                    console.log("Aquest Usuari no existeix, és extrany oi?")
                    return false;
                } else {
                    console.log("Usuari borrat amb éxit")
                    return true;
                }
            });

            con.end(function(err) {
                if (err){
                    return console.log('error:' + err.message);
                }
            });
        }
    });
});

function iplog(username, req){
    fs.appendFile("iplogs.txt", username+" "+req.ip + " " + new Date()+"\n",function(err) {
        if(err) {
            return console.log(err);
        }
        console.log("The file was saved!");
    }); 
}




const PORT = 3000;

app.listen(PORT, () =>{
    console.log("Server running =>"+PORT)});





