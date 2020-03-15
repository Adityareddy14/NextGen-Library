var crypto = require('crypto');
var uuid = require('uuid');
var express = require('express');
var mysql = require('mysql');
var bodyParser = require('body-parser');

//connect to mysql
var con = mysql.createConnection({
   host:'localhost',
   user:'root',
   password:'1410',
   database:'library'
});
con.connect(function(err) {
    if (err) throw err;
    console.log("Connected!");
  });
//password util
var genRandomString=function(length){
 return crypto.randomBytes(Math.ceil(length/2))
    .toString('hex')
    .slice(0,length);
};

var sha512 = function(password,salt){
     var hash = crypto.createHmac('sha512',salt);
     hash.update(password);
     var value = hash.digest('hex');
     return{
         salt:salt,
         passwordHash:value  
     };
};

function saltHashPassword(userPassword){
    var salt = genRandomString(16);
    var passwordData = sha512(userPassword,salt);
    return passwordData;
}

function checkHashPassword(userPassword,salt){
    var passwordData = sha512(userPassword,salt);
    return passwordData;
}


var app=express();
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended : true}));


app.post('/register/',(req,res,next)=>{
  var post_data = req.body;
  console.log('Requested!!');
  var uid = Math.floor(Math.random()*900000) + 100000;
  var plaint_password = post_data.password;
  var hash_data = saltHashPassword(plaint_password);
  var password = hash_data.passwordHash;
  var salt = hash_data.salt;
  var name = post_data.name;
  var email = post_data.email;
  var id = post_data.id;
  var phone = post_data.mobile;
  

  con.query('SELECT * FROM user where email=?',[email],function(err,result,fields){
     con.on('error',function(err){
         console.log('[MySQL Error]',err);
     });

    if(result && result.length)
        res.json('User already exists!!!');
    else
    {
     con.query('INSERT INTO user (user_id,id,user_name,user_email,encrypted_password,salt,user_phone) VALUES (?,?,?,?,?,?,?)',[uid,id,name,email,password,salt,phone],function(err,result,fields){
        if(err){
            throw err
        }
        res.json('Register successful');
      })
   }
  });

})


app.post('/login/',(req,res,next)=>{
 
    var post_data = req.body;
    console.log('Requested');
    //extract email and password from request
    var user_password = post_data.password;
    var email = post_data.email;

    con.query('SELECT * FROM user where user_email=?',[email],function(err,result,fields){


        if(err){
            throw err
        }
   
       if(result && result.length)
       {
        var salt = result[0].salt;
        var encrypted_password = result[0].encrypted_password;
        var hashed_password = checkHashPassword(user_password,salt).passwordHash;
        if(encrypted_password == hashed_password)
        {
           res.end(JSON.stringify(result[0]))
           
        }
        else
        {
            res.end(JSON.stringify('Wrong password'));
        }
       }

       else
       {
        res.json("User not exists!!");
      }
        
     });

})




app.post('/forgot/',(req,res,next)=>{
    var post_data = req.body;
    console.log('Requested');
    //extract email and password from request
    var user_password = post_data.password;
    var email = post_data.email;
    var name = post_data.name;
    var mobile = post_data.mobile;

    var p = Math.floor(Math.random()*900000) + 100000;
    var hash_data = saltHashPassword(String(p));
    var password = hash_data.passwordHash;
    var salt = hash_data.salt;
    console.log(p)

    var str = String(p)
    var nodemailer = require('nodemailer');
    var transporter = nodemailer.createTransport({
        service: 'gmail' ,
        auth: {
            user: 'amritalibrary.management@gmail.com' ,
            pass: 'amrita99'
        }
    });

    var mailOptions = {
      from: 'amritalibrary.management@gmail.com' ,
      to: email ,
      subject: 'New Password',
      text: str
    };

    
 

    con.query('SELECT * FROM user where user_email=?',[email],function(err,result,fields){

        if(err){
            console.log(err)
        }
   
       if(result && result.length)
       {

       if((name == result[0].user_name) && (mobile == result[0].user_phone)){
        var sql = "update user set encrypted_password='"+password+"'  , salt= '"+salt+"' where user_email = '"+email+"';"
        con.query(sql,function(err,result){
            if (err)
            console.log(err)
        })
           
        transporter.sendMail(mailOptions,
            function(error,info){
                if(error){
                    console.log(error);
                } else{
                    console.log('Email sent:'+info.response);
                }
            });
        
        
           res.end(JSON.stringify(result[0]))
       }
       else{
        res.end(JSON.stringify('Enter correct credentials'));
       }
       
       }

       else
       {
        res.json("User not exists!!");
      }
        
     });

})



app.post('/books/',(req,res,next)=>{
 
    var post_data = req.body;
    console.log('Requested');
    //extract email and password from request
    var val = post_data.val;
    

    con.query('SELECT * FROM books',function(err,result,fields){
        if(err){
            throw err
        }

        res.send(result);
     });

})


  

//start server
app.listen(5000,()=>{
    console.log('Restful running on port 5000');
})


