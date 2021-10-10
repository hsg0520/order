module.exports = {
    outputDir: "../src/main/resources/static",
    indexPath: "../static/index.html",
    devServer: {
        port: 8000,
        proxy: {
          '/api': { //url에 /api패턴이 있을경우 spring rest api 9000포트를 바로보게 한다.
            target: 'http://localhost:9000',
            // changeOrigin:true
          }
        }
    }
};