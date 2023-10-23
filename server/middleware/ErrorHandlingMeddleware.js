const apiError = require('../error/ApiError')

module.exports = function (err,req,res,next){
    if (err instanceof apiError) {
        res.status(err.status).json({message: err.message})
    }
}