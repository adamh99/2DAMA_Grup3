const express = require("express");
const cors = require ("cors");
const mysql = require ("mysql2");


const app = express();

var con  = mysql.createConnection ({
    host: "labs.inspedralbes.cat",
    user: "a21marsanbla_grup3",
    password: "Projecte123",
    database: "a21marsanbla_project"
});

/*con.connect(function(err){
    if(err) throw err;
    else{
        console.log("Successfully connected");

        let sql = "SELECT * FROM usuari WHERE "





    }
});*/




//autetificació de Usuari.
app.get("/auth/:user/:pwd", (req, res) => {

    let user = req.params.user;
    let password = req.params.pwd;

    let config = {
        auth: false,
        role: "",
        text: ""
    };
    

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
                    config.text = "Benvingut/da " + user;
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

    let user = req.params.user;
    let password = req.params.pwd;

    let creation = {
        text: ""
    };

    if(userExists(user)){
        creation.text = "Ja existeix un usuari amb aquests paràmetres, canvia el nom siusplau";
    } else {
        insertUser(user,password);
    }
    
    let str = JSON.stringify(creation);
    res.send(str);
});




//Funcions de suport
//CHECK IF USER EXIST
function userExists (nom) {

    
    let exist;

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
function insertUser(nom, password){
    
    
    let insertOK;

    con.connect(function(err){
        if(err) throw err;
        else {

            let sql = "INSER INTO usuari (NOM,PASS)VALUES ('" + nom + "', '" + password + "')";

            con.query(sqlInsert, function (err, result){
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






const PORT = 3000;

app.listen(PORT, () =>{
    console.log("Server running =>"+PORT)});





