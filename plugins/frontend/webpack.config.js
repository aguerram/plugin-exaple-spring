const path = require('path');
const webpack = require('webpack');
const CompressionPlugin = require("compression-webpack-plugin");

const outPutDir = path.resolve(__dirname, '../src/main/resources/static')
const isProd = process.env.NODE_ENV === "production"
const productionPlugins = isProd ?
    [
        new CompressionPlugin({
            algorithm: "gzip",
        })
    ] :
    []

module.exports = {
    entry: path.resolve(__dirname, './src/main.js'),
    module: {
        rules: [
            {
                test: /\.(js|jsx)$/,
                exclude: /node_modules/,
                use: ['babel-loader'],
            },
        ],
    },
    resolve: {
        extensions: ['*', '.js', '.jsx'],
    },
    output: {
        // path: path.resolve(__dirname, './dist'),
        path: outPutDir,
        filename: 'bundle.js',
    },
    plugins: [
        new webpack.HotModuleReplacementPlugin(),
        ...productionPlugins
    ],
    devServer: {
        contentBase: outPutDir,
        hot: true
    },
};